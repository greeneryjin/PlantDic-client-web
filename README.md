# [식물 사전](https://www.notion.so/cea50616f805494b9018a1494b43b282?p=3cf48925dea944509d2b935460c3c670&pm=c)
Querydsl를 사용한 동적 필터 식물사전 사이트 개발

### 목차 
[1. 기능 및 핵심 코드](#important)


[2. 트러블 슈팅](#troubleshooting) 


[3. 리팩토링](#refactoring)


[4. 사용한 개발 도구 및 라이브러리](#tool)


[5. 완성된 App 이미지](#image)

# important
#### 기능
- 여러 필터 기능을 선택하여 식물을 조회함 
필터 목록
- 분류, 광도, 습도, 온도, 잎색, 잎 무늬, 난이도, 장소 


동적 필터를 받아오는 dto
```java 
@Getter
public class FilterDto {

    //검색 조건
    private String clCode;
    private String lighttdemanddoCode;
    @Column(length = 30)
    private String hdCode;
    private String grwhTpCode;
    private String lefcolrCode;
    private String lefmrkCode;
    private String managelevelCode;
    private String postngplaceCode;


    public FilterDto(String clCode, String lighttdemanddoCode,String hdCode,String grwhTpCode
            ,String lefcolrCode, String lefmrkCode, String managelevelCode,String postngplaceCode) {
        this.clCode = clCode;
        this.lighttdemanddoCode = lighttdemanddoCode;
        this.hdCode = hdCode;
        this.grwhTpCode = grwhTpCode;
        this.lefcolrCode = lefcolrCode;
        this.lefmrkCode = lefmrkCode;
        this.managelevelCode = managelevelCode;
        this.postngplaceCode = postngplaceCode;
    }
}
````

필터를 처리하는 로직
```java
    @Override
    public Page<MyGardenDtl> searchFilter(Pageable pageable, FilterDto filter) {
        QueryResults<MyGardenDtl> queryResults = queryFactory
                .selectFrom(myGardenDtl)
                .where(filterSum(filter.getClCode(), filter.getLighttdemanddoCode(), filter.getHdCode(), filter.getGrwhTpCode()
                        ,filter.getLefcolrCode(), filter.getLefmrkCode(), filter.getManagelevelCode(), filter.getPostngplaceCode()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<MyGardenDtl> content = queryResults.getResults();
        long total = queryResults.getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    private BooleanBuilder clCode(String clCode) {
        if(clCode == null) {
            return new BooleanBuilder();
        }else {
            return new BooleanBuilder(myGardenDtl.clCode.contains(clCode));
        }
    }
```

# troubleshooting

1. CORS 문제
React, Spring Boot에서 자원을 요청할 때 두 자원의 리소스 출처가 다르면 발생하는 문제로 서버에서 요청을 차단하는 것입니다.

수정된 코드 
```JAVA
@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsFilter(){

        //자바스크립트로 요청이 오면 처리
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowCredentials(true);
        configuration.addAllowedOriginPattern("*");
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","OPTIONS","DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
```
원래는 configuration.allowedOrigins를 사용했으나 시큐리티에서 찍힌 로그를 보니 configuration.addAllowedOriginPattern로 변경해서 사용해야 정상 작동한다고 합니다. 

2. JSON 직렬화 순환 참조
1:N일 때 Entity를 직접 조회했을 때 발생했습니다.
```java
@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyGardenDtl {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "myGardendtl_id")
    private Long id;

    @Builder.Default
    @OneToMany(mappedBy = "myGardenDtl", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MyGardenDtlPicture> myGardenDtlPictures = new ArrayList<>();

    //병충해 정보
    @OneToMany(mappedBy = "myGardenDtl", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pest> pests = new ArrayList<>();
```
MyGardenDtl -> pests 직렬화 -> pests 내부 MyGardenDtl 직렬화
: 무한 순환 반복 


해결 방법
DTO 사용 
```JAVA
public Header<PestDto> pestUpdate(@PathVariable("id")Long id,@RequestBody PestSaveDto pestSaveDto){
     Pest pest = mygardenAdminService.pestUpdate(id, pestSaveDto);
     PestDto pestDto = PestDto.of(pest);
     return Header.OK(pestDto);
}

public static PestDto of(Pest pest){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(pest, PestDto.class);
}
```

# refactoring
@PutMapping 사용 시 추가로 저장하는 것을 수정함 
##### 기존 코드
```JAVA
//식물 사전 수정 전
@Transactional
public PlantDic updatePlant(Long id, PlantChangeDto plantChangeDto){
   PlantDic plantDic = findByPlantId(id);
   plantDic.changePlant(plantChangeDto);
   plantDicRepository.save(plantDic);
   return plantDic;
}
```
데이터를 수정하기 위해 @Transactional를 넣고 다시 save()를 사용했습니다. 
하지만 Spring data JPA에서는 변경 감지를 사용하기 때문에 다시 저장할 필요가 없습니다. 

##### 수정된 코드
```JAVA
//식물 사전 수정 후
@Transactional
public PlantDic updatePlant(Long id, PlantChangeDto plantChangeDto){
    PlantDic plantDic = findByPlantId(id);
    plantDic.changePlant(plantChangeDto);
    return plantDic;
}
```

# tool
사용 언어
```
- JAVA 8
- js
```

사용 기술
```
- springboot
- Mysql
- Querydsl
- jpa
```

라이브러리
```
- lombok
- gradle
- react
```

# image
완성된 웹사이트 
<img width="1000" alt="사진" src="https://user-images.githubusercontent.com/87289562/216971512-6f2b4181-82cc-4f53-9d23-5c4b24bafd21.png">

Flow chart

<img width="193" alt="식물사전" src="https://user-images.githubusercontent.com/87289562/217509006-48eaae35-ebfb-4587-8607-a0d8cc7e6262.PNG">
