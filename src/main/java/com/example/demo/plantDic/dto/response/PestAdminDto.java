package com.example.demo.plantDic.dto.response;

import com.example.demo.plantDic.model.Pest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data //관리자 페이지에서 전체 조회 시 사용.
public class PestAdminDto {

    private Long id;
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

    private List<String> pestImageNames;

    public PestAdminDto(Pest pest) {
        id = pest.getId();
        pestCode = pest.getPestCode();
        pestCodeNm = pest.getPestCodeNm();
        pestEng = pest.getPestEng();
        pestDetail = pest.getPestDetail();
        pestPlantSymptom = pest.getPestPlantSymptom();
        pestCtrl = pest.getPestCtrl();
        pestMonth = pest.getPestMonth();
        pestUrl = pest.getPestUrl();
        pestImageName = pest.getPestImageName();
        setArr(this.pestImageName);
    }

    private void setArr(String picture) {
        String url = picture;
        if(url.matches(".*\\|*.")){
            String[] strArr = url.split("\\|");
            List<String> arr = Arrays.asList(strArr);
            setPestImageNames(arr);
        }else;
    }
}
