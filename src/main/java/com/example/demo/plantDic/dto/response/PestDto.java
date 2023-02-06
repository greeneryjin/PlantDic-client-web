package com.example.demo.plantDic.dto.response;

import com.example.demo.plantDic.model.Pest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter @Setter //해충 조회
@NoArgsConstructor
public class PestDto {

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

    public static PestDto of(Pest pest){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(pest, PestDto.class);
    }

    public PestDto(Pest pest) {
        this.id = pest.getId();
        this.pestCode = pest.getPestCode();
        this.pestCodeNm = pest.getPestCodeNm();
        this.pestEng = pest.getPestEng();
        this.pestDetail = pest.getPestDetail();
        this.pestPlantSymptom = pest.getPestPlantSymptom();
        this.pestCtrl = pest.getPestCtrl();
        this.pestMonth = pest.getPestMonth();
        this.pestUrl = pest.getPestUrl();
        this.pestImageName = pest.getPestImageName();
    }
}
