package com.example.demo.plantDic.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor //식물 수정 dto
public class PlantChangeDto {

    private String cntntsSj;

    private String plntbneNm;
    private String plntzrNm;

    private String fmlCodeNm;
    private String fmlNm;

    private String managelevelCode;
    private String managelevelCodeNm;

    private String grwhTpCode;
    private String grwhTpCodeNm;

    private String winterLwetTpCode;
    private String winterLwetTpCodeNm;

    private String hdCode;
    private String hdCodeNm;

    private String watercycleSprngCode;
    private String watercycleSprngCodeNm;

    private String watercycleSummerCode;
    private String watercycleSummerCodeNm;

    private String watercycleAutumnCode;
    private String watercycleAutumnCodeNm;

    private String watercycleWinterCode;
    private String watercycleWinterCodeNm;

    private String managedemanddoCode;
    private String managedemanddoCodeNm;

    private String clCode;
    private String clCodeNm;

    private String lefmrkCode;
    private String lefmrkCodeNm;

    private String lefcolrCode;
    private String lefcolrCodeNm;

    private String flclrCode;
    private String flclrCodeNm;

    private String lighttdemanddoCode;
    private String lighttdemanddoCodeNm;

    private String postngplaceCode;
    private String postngplaceCodeNm;

    private String clCodeEng;
    private String clCodeDetail;

    private String fmlCodeEng;
    private String fmlCodeDetail;

    private String orgPlaceEng;
    private String orgPlaceDetail;
    private String orgplceInfo;

    private String lighttdDetail;
    private String grwhTpCodeDetail;
    private String hdCodeDetail;
    private String postngplaceDetail;

    //세부 정보(꽃말, 꽃 설명)
    private String descriptionShort;
    private String descriptionDetail;
    private String flIng;
}
