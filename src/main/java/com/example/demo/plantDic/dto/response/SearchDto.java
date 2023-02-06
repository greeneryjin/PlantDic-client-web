package com.example.demo.plantDic.dto.response;

import com.example.demo.plantDic.model.MyGardenDtl;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter //식물 & 사진 & 해충 조회
public class SearchDto {

    private Long id;

    //사진 정보
    private List<PictureDto> myGardenDtlPictures;
    private List<PestNameDto> pest;

    //세부 정보
    private String descriptionShort;
    private String descriptionDetail;
    private String flIng;

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

    public String hdCode;
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

    public String clCode;
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

    public SearchDto(MyGardenDtl myGardenDtl) {
        this.myGardenDtlPictures = myGardenDtl.getMyGardenDtlPictures()
                .stream().map(myGardenDtlPicture -> new PictureDto(myGardenDtlPicture)).collect(Collectors.toList());
        this.pest = myGardenDtl.getPests().stream()
                .map(pest -> new PestNameDto(pest)).collect(Collectors.toList());
        this.descriptionShort = myGardenDtl.getDescriptionShort();
        this.descriptionDetail = myGardenDtl.getDescriptionDetail();
        this.flIng = myGardenDtl.getFlIng();
        this.id = myGardenDtl.getId();
        this.cntntsSj = myGardenDtl.getCntntsSj();
        this.plntbneNm = myGardenDtl.getPlntbneNm();
        this.plntzrNm = myGardenDtl.getPlntzrNm();
        this.fmlCodeNm = myGardenDtl.getFmlCodeNm();
        this.fmlNm = myGardenDtl.getFmlNm();
        this.orgplceInfo = myGardenDtl.getOrgplceInfo();
        this.managelevelCode = myGardenDtl.getManagelevelCode();
        this.managelevelCodeNm = myGardenDtl.getManagelevelCodeNm();
        this.grwhTpCode = myGardenDtl.getGrwhTpCode();
        this.grwhTpCodeNm = myGardenDtl.getGrwhTpCodeNm();
        this.winterLwetTpCode = myGardenDtl.getWinterLwetTpCode();
        this.winterLwetTpCodeNm = myGardenDtl.getWinterLwetTpCodeNm();
        this.hdCode = myGardenDtl.getHdCode();
        this.hdCodeNm = myGardenDtl.getHdCodeNm();
        this.watercycleSprngCode = myGardenDtl.getWatercycleSprngCode();
        this.watercycleSprngCodeNm = myGardenDtl.getWatercycleSprngCodeNm();
        this.watercycleSummerCode = myGardenDtl.getWatercycleSummerCode();
        this.watercycleSummerCodeNm = myGardenDtl.getWatercycleSummerCodeNm();
        this.watercycleAutumnCode = myGardenDtl.getWatercycleAutumnCode();
        this.watercycleAutumnCodeNm = myGardenDtl.getWatercycleAutumnCodeNm();
        this.watercycleWinterCode = myGardenDtl.getWatercycleWinterCode();
        this.watercycleWinterCodeNm = myGardenDtl.getWatercycleWinterCodeNm();
        this.managedemanddoCode = myGardenDtl.getManagedemanddoCode();
        this.managedemanddoCodeNm = myGardenDtl.getManagedemanddoCodeNm();
        this.clCode = myGardenDtl.getClCode();
        this.clCodeNm = myGardenDtl.getClCodeNm();
        this.lefmrkCode = myGardenDtl.getLefmrkCode();
        this.lefmrkCodeNm = myGardenDtl.getLefmrkCodeNm();
        this.lefcolrCode = myGardenDtl.getLefcolrCode();
        this.lefcolrCodeNm = myGardenDtl.getLefcolrCodeNm();
        this.flclrCode = myGardenDtl.getFlclrCode();
        this.flclrCodeNm = myGardenDtl.getFlclrCodeNm();
        this.lighttdemanddoCode = myGardenDtl.getLighttdemanddoCode();
        this.lighttdemanddoCodeNm = myGardenDtl.getLighttdemanddoCodeNm();
        this.postngplaceCode = myGardenDtl.getPostngplaceCode();
        this.postngplaceCodeNm = myGardenDtl.getPostngplaceCodeNm();
        this.clCodeEng = myGardenDtl.getClCodeEng();
        this.clCodeDetail = myGardenDtl.getClCodeDetail();
        this.fmlCodeEng = myGardenDtl.getFmlCodeEng();
        this.fmlCodeDetail = myGardenDtl.getFmlCodeDetail();
        this.orgPlaceEng = myGardenDtl.getOrgPlaceEng();
        this.orgPlaceDetail = myGardenDtl.getOrgPlaceDetail();
        this.grwhTpCodeDetail = myGardenDtl.getGrwhTpCodeDetail();
        this.lighttdDetail = myGardenDtl.getLighttdDetail();
        this.postngplaceDetail = myGardenDtl.getPostngplaceDetail();
        this.hdCodeDetail = myGardenDtl.getHdCodeDetail();
    }
}
