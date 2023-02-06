package com.example.demo.plantDic.model;

import com.example.demo.plantDic.dto.request.PlantChangeDto;
import com.example.demo.plantDic.dto.request.PlantSaveDto;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"myGardenDtlName", "myGardenDtlPictures"})
public class MyGardenDtl {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "myGardendtl_id")
    private Long id;

    //식물 사진 정보
    @Builder.Default
    @OneToMany(mappedBy = "myGardenDtl", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MyGardenDtlPicture> myGardenDtlPictures = new ArrayList<>();

    //병충해 정보
    @OneToMany(mappedBy = "myGardenDtl", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pest> pests = new ArrayList<>();

    public void addPicture(MyGardenDtlPicture myGardenDtlPicture){
        myGardenDtlPictures.add(myGardenDtlPicture);
        if(myGardenDtlPicture.getMyGardenDtl() != this){
            myGardenDtlPicture.setMyGardenDtl(this);
        }
    }

    public void addPest(Pest pest){
        pests.add(pest);
        if(pest.getMyGardenDtl() != this){
            pest.setMyGardenDtl(this);
        }
    }

    @Column(length = 100)
    private String cntntsSj;

    private String plntbneNm;
    private String plntzrNm;

    private String fmlCodeNm;
    @Column(length = 30)
    private String fmlNm;

    private String orgplceInfo;

    @Column(length = 30)
    private String managelevelCode;
    @Column(length = 30)
    private String managelevelCodeNm;

    @Column(length = 30)
    private String grwhTpCode;
    @Column(length = 30)
    private String grwhTpCodeNm;

    private String winterLwetTpCode;
    private String winterLwetTpCodeNm;

    @Column(length = 30)
    public String hdCode;
    @Column(length = 30)
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

    @Column(length = 100)
    private String clCodeEng;

    @Column(length = 100)
    private String clCodeDetail;

    @Column(length = 100)
    private String fmlCodeEng;

    @Column(length = 100)
    private String fmlCodeDetail;

    @Column(length = 100)
    private String orgPlaceEng;

    @Column(length = 100)
    private String orgPlaceDetail;

    @Column(length = 100)
    private String lighttdDetail;

    @Column(length = 100)
    private String grwhTpCodeDetail;

    @Column(length = 50)
    private String postngplaceDetail;

    @Column(length = 30)
    private String hdCodeDetail;

    @Column(length = 1000)
    private String descriptionShort;

    //식물 세부 설명
    @Column(length = 1000)
    private String descriptionDetail;

    //꽃말
    @Column(length = 1000)
    private String flIng;

    public void saveData(PlantSaveDto plantSaveDto){
        this.cntntsSj = plantSaveDto.getCntntsSj();
        this.plntbneNm = plantSaveDto.getPlntbneNm();
        this.plntzrNm = plantSaveDto.getPlntzrNm();
        this.fmlCodeNm = plantSaveDto.getFmlCodeNm();
        this.fmlNm = plantSaveDto.getFmlNm();
        this.orgplceInfo = plantSaveDto.getOrgplceInfo();
        this.managelevelCode = plantSaveDto.getManagelevelCode();
        this.managelevelCodeNm = plantSaveDto.getManagelevelCodeNm();
        this.grwhTpCode = plantSaveDto.getGrwhTpCode();
        this.grwhTpCodeNm = plantSaveDto.getGrwhTpCodeNm();
        this.winterLwetTpCode = plantSaveDto.getWinterLwetTpCode();
        this.winterLwetTpCodeNm = plantSaveDto.getWinterLwetTpCodeNm();
        this.hdCode = plantSaveDto.getHdCode();
        this.hdCodeNm = plantSaveDto.getHdCodeNm();
        this.watercycleSprngCode = plantSaveDto.getWatercycleSprngCode();
        this.watercycleSprngCodeNm = plantSaveDto.getWatercycleSprngCodeNm();
        this.watercycleSummerCode = plantSaveDto.getWatercycleSummerCode();
        this.watercycleSummerCodeNm = plantSaveDto.getWatercycleSummerCodeNm();
        this.watercycleAutumnCode = plantSaveDto.getWatercycleAutumnCode();
        this.watercycleAutumnCodeNm = plantSaveDto.getWatercycleAutumnCodeNm();
        this.watercycleWinterCode = plantSaveDto.getWatercycleWinterCode();
        this.watercycleWinterCodeNm = plantSaveDto.getWatercycleWinterCodeNm();
        this.managedemanddoCode = plantSaveDto.getManagedemanddoCode();
        this.managedemanddoCodeNm = plantSaveDto.getManagedemanddoCodeNm();
        this.clCode = plantSaveDto.getClCode();
        this.clCodeNm = plantSaveDto.getClCodeNm();
        this.lefmrkCode = plantSaveDto.getLefmrkCode();
        this.lefmrkCodeNm = plantSaveDto.getLefmrkCodeNm();
        this.lefcolrCode = plantSaveDto.getLefcolrCode();
        this.lefcolrCodeNm = plantSaveDto.getLefcolrCodeNm();
        this.flclrCode = plantSaveDto.getFlclrCode();
        this.flclrCodeNm = plantSaveDto.getFlclrCodeNm();
        this.lighttdemanddoCode = plantSaveDto.getLighttdemanddoCode();
        this.lighttdemanddoCodeNm = plantSaveDto.getLighttdemanddoCodeNm();
        this.postngplaceCode = plantSaveDto.getPostngplaceCode();
        this.postngplaceCodeNm = plantSaveDto.getPostngplaceCodeNm();
        this.clCodeEng = plantSaveDto.getClCodeEng();
        this.fmlCodeEng = plantSaveDto.getFmlCodeEng();
        this.orgPlaceEng = plantSaveDto.getOrgPlaceEng();
        this.descriptionShort = plantSaveDto.getDescriptionShort();
        this.descriptionDetail = plantSaveDto.getDescriptionDetail();
        this.flIng = plantSaveDto.getFlIng();
        this.grwhTpCodeDetail = plantSaveDto.getGrwhTpCodeDetail();
        this.hdCodeDetail = plantSaveDto.getHdCodeDetail();
        this.orgPlaceDetail = plantSaveDto.getOrgPlaceDetail();
        this.clCodeDetail = plantSaveDto.getClCodeDetail();
        this.fmlCodeDetail = plantSaveDto.getFmlCodeDetail();
        this.lighttdDetail = plantSaveDto.getLighttdDetail();
        this.postngplaceDetail = plantSaveDto.getPostngplaceDetail();
    }

    public void changeData(PlantChangeDto plantChangeDto) {
        this.cntntsSj = plantChangeDto.getCntntsSj();
        this.plntbneNm = plantChangeDto.getPlntbneNm();
        this.plntzrNm = plantChangeDto.getPlntzrNm();
        this.fmlCodeNm = plantChangeDto.getFmlCodeNm();
        this.fmlNm = plantChangeDto.getFmlNm();
        this.orgplceInfo = plantChangeDto.getOrgplceInfo();
        this.managelevelCode = plantChangeDto.getManagelevelCode();
        this.managelevelCodeNm = plantChangeDto.getManagelevelCodeNm();
        this.grwhTpCode = plantChangeDto.getGrwhTpCode();
        this.grwhTpCodeNm = plantChangeDto.getGrwhTpCodeNm();
        this.winterLwetTpCode = plantChangeDto.getWinterLwetTpCode();
        this.winterLwetTpCodeNm = plantChangeDto.getWinterLwetTpCodeNm();
        this.hdCode = plantChangeDto.getHdCode();
        this.hdCodeNm = plantChangeDto.getHdCodeNm();
        this.watercycleSprngCode = plantChangeDto.getWatercycleSprngCode();
        this.watercycleSprngCodeNm = plantChangeDto.getWatercycleSprngCodeNm();
        this.watercycleSummerCode = plantChangeDto.getWatercycleSummerCode();
        this.watercycleSummerCodeNm = plantChangeDto.getWatercycleSummerCodeNm();
        this.watercycleAutumnCode = plantChangeDto.getWatercycleAutumnCode();
        this.watercycleAutumnCodeNm = plantChangeDto.getWatercycleAutumnCodeNm();
        this.watercycleWinterCode = plantChangeDto.getWatercycleWinterCode();
        this.watercycleWinterCodeNm = plantChangeDto.getWatercycleWinterCodeNm();
        this.managedemanddoCode = plantChangeDto.getManagedemanddoCode();
        this.managedemanddoCodeNm = plantChangeDto.getManagedemanddoCodeNm();
        this.clCode = plantChangeDto.getClCode();
        this.clCodeNm = plantChangeDto.getClCodeNm();
        this.lefmrkCode = plantChangeDto.getLefmrkCode();
        this.lefmrkCodeNm = plantChangeDto.getLefmrkCodeNm();
        this.lefcolrCode = plantChangeDto.getLefcolrCode();
        this.lefcolrCodeNm = plantChangeDto.getLefcolrCodeNm();
        this.flclrCode = plantChangeDto.getFlclrCode();
        this.flclrCodeNm = plantChangeDto.getFlclrCodeNm();
        this.lighttdemanddoCode = plantChangeDto.getLighttdemanddoCode();
        this.lighttdemanddoCodeNm = plantChangeDto.getLighttdemanddoCodeNm();
        this.postngplaceCode = plantChangeDto.getPostngplaceCode();
        this.postngplaceCodeNm = plantChangeDto.getPostngplaceCodeNm();
        this.clCodeEng = plantChangeDto.getClCodeEng();
        this.fmlCodeEng = plantChangeDto.getFmlCodeEng();
        this.orgPlaceEng = plantChangeDto.getOrgPlaceEng();
        this.descriptionShort = plantChangeDto.getDescriptionShort();
        this.descriptionDetail = plantChangeDto.getDescriptionDetail();
        this.flIng = plantChangeDto.getFlIng();
        this.grwhTpCodeDetail = plantChangeDto.getGrwhTpCodeDetail();
        this.hdCodeDetail = plantChangeDto.getHdCodeDetail();
        this.orgPlaceDetail = plantChangeDto.getOrgPlaceDetail();
        this.clCodeDetail = plantChangeDto.getClCodeDetail();
        this.fmlCodeDetail = plantChangeDto.getFmlCodeDetail();
        this.lighttdDetail = plantChangeDto.getLighttdDetail();
        this.postngplaceDetail = plantChangeDto.getPostngplaceDetail();
    }
}
