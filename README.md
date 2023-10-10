# 식물 사전 사이트(client)
Querydsl를 사용한 동적 필터 식물사전 사이트 개발


사용 언어
```
- JAVA 8
- react
```

사용 기술
```
- springboot
- Mysql
- Querydsl
- spring data jpa
- spring jpa
```

라이브러리
```
- lombok
- gradle
```

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


완성된 웹사이트 
<img width="1000" alt="사진" src="https://user-images.githubusercontent.com/87289562/216971512-6f2b4181-82cc-4f53-9d23-5c4b24bafd21.png">

Flow chart

<img width="193" alt="식물사전" src="https://user-images.githubusercontent.com/87289562/217509006-48eaae35-ebfb-4587-8607-a0d8cc7e6262.PNG">
