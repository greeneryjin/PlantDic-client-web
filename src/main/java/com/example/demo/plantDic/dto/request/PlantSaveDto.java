package com.example.demo.plantDic.dto.request;

import com.example.demo.plantDic.model.MyGardenDtl;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor //식물 저장 dto
public class PlantSaveDto {

    private Long id;
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

    //병풍해 정보
    private String pestCodeNm;

    public MyGardenDtl entity() {
        return MyGardenDtl.builder()
                .id(id)
                .cntntsSj(cntntsSj)
                .plntbneNm(plntbneNm)
                .plntzrNm(plntzrNm)
                .fmlCodeNm(fmlCodeNm)
                .fmlNm(fmlNm)
                .orgplceInfo(orgplceInfo)
                .managelevelCode(managelevelCode)
                .managedemanddoCodeNm(managedemanddoCodeNm)
                .grwhTpCode(grwhTpCode)
                .grwhTpCodeNm(grwhTpCodeNm)
                .winterLwetTpCode(winterLwetTpCode)
                .winterLwetTpCodeNm(winterLwetTpCodeNm)
                .hdCode(hdCode)
                .hdCodeNm(hdCodeNm)
                .watercycleSprngCode(watercycleSprngCode)
                .watercycleSprngCodeNm(watercycleSprngCodeNm)
                .watercycleSummerCode(watercycleSummerCode)
                .watercycleSummerCodeNm(watercycleSummerCodeNm)
                .watercycleAutumnCode(watercycleAutumnCode)
                .watercycleAutumnCodeNm(watercycleAutumnCodeNm)
                .watercycleWinterCode(watercycleWinterCode)
                .watercycleWinterCodeNm(watercycleWinterCodeNm)
                .managedemanddoCode(managedemanddoCode)
                .managedemanddoCodeNm(managedemanddoCodeNm)
                .clCode(clCode)
                .clCodeNm(clCodeNm)
                .lefcolrCode(lefcolrCode)
                .lefcolrCodeNm(lefcolrCodeNm)
                .flclrCode(flclrCode)
                .flclrCodeNm(flclrCodeNm)
                .lighttdemanddoCode(lighttdemanddoCode)
                .lighttdemanddoCodeNm(lighttdemanddoCodeNm)
                .postngplaceCode(postngplaceCode)
                .postngplaceCodeNm(postngplaceCodeNm)
                .clCodeDetail(clCodeDetail)
                .clCodeEng(clCodeEng)
                .fmlCodeEng(fmlCodeEng)
                .fmlCodeDetail(fmlCodeDetail)
                .orgPlaceEng(orgPlaceEng)
                .orgPlaceDetail(orgPlaceDetail)
                .hdCodeDetail(hdCodeDetail)
                .lighttdDetail(lighttdDetail)
                .grwhTpCodeDetail(grwhTpCodeDetail)
                .postngplaceDetail(postngplaceDetail)
                .descriptionShort(descriptionShort)
                .descriptionDetail(descriptionDetail)
                .flIng(flIng)
                .build();
    }
}
