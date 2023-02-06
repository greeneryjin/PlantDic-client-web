package com.example.demo.plantDic.dto.response;

import com.example.demo.plantDic.model.Pest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //해충 이름 조회
public class PestNameDto {

    private Long id;
    private String pestCode;
    private String pestCodeNm;


    public PestNameDto(Pest pest) {
        id = pest.getId();
        pestCode = pest.getPestCode();
        pestCodeNm = pest.getPestCodeNm();
    }
}
