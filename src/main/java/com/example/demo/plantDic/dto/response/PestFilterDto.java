package com.example.demo.plantDic.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

//필터 조회 사용
public class PestFilterDto {

    private String pestCode;
    private String pestCodeNm;
    private String pestEng;
    private String pestDetail;
    private String pestPlantSymptom;
    private String pestCtrl;
    private String pestMonth;
    private String pestUrl;

    @JsonIgnore
    private String pestImageName;
    private List<String> pestArray;

    public PestFilterDto(String pestCode, String pestCodeNm, String pestEng, String pestDetail,
                         String pestPlantSymptom, String pestCtrl, String pestMonth, String pestUrl,
                         String pestImageName) {
        this.pestCode = pestCode;
        this.pestCodeNm = pestCodeNm;
        this.pestEng = pestEng;
        this.pestDetail = pestDetail;
        this.pestPlantSymptom = pestPlantSymptom;
        this.pestCtrl = pestCtrl;
        this.pestMonth = pestMonth;
        this.pestUrl = pestUrl;
        this.pestImageName = pestImageName;
    }
}
