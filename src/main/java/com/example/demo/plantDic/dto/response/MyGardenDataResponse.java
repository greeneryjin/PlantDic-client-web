package com.example.demo.plantDic.dto.response;
import com.example.demo.plantDic.model.MyGardenDtl;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor //식물만 조회
public class MyGardenDataResponse {

    private Long id;

    private String cntntsSj;

    private String plntbneNm;
    private String plntzrNm;

    private String fmlNm;
    private String fmlCodeNm;

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
    private String postngplaceDetail;
    private String hdCodeDetail;

    private String descriptionShort;
    private String descriptionDetail;
    private String flIng;


    //Entity -> Dto
    public static MyGardenDataResponse of(MyGardenDtl myGardenDtl) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(myGardenDtl, MyGardenDataResponse.class);
    }
}
