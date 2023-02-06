# Querydsl-filter
Querydsl를 사용한 동적 필터 식물사전 사이트 개발


사용 언어
- JAVA 8


사용 기술
- spring-boot
- spring
- Mysql
- react
- Querydsl
- spring data jpa
- spring jpa


라이브러리
- lombok
- gradle


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
