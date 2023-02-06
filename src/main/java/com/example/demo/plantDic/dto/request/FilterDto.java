package com.example.demo.plantDic.dto.request;

import lombok.Getter;

import javax.persistence.Column;

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
