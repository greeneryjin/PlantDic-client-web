package com.example.demo.plantDic.dto.response;

import com.example.demo.plantDic.model.MyGardenDtlPicture;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter @Setter //식물 사진
public class PictureDto {

    //인스타 링크
    private String userLink;

    private List<String> userIds;

    private String imageUrlPrefix;

    @JsonIgnore
    private String userid;

    @JsonIgnore
    private String imageUrls;

    //이미지 저장 주소 + 인스타 아이디 -> 사진 링크
    private List<String> imageUrlArray;

    public PictureDto(MyGardenDtlPicture myGardenDtlPicture) {
        this.userid = myGardenDtlPicture.getUserid();
        setArrUserId(this.userid);
        this.userLink = myGardenDtlPicture.getUserLink();
        this.imageUrls = myGardenDtlPicture.getImageUrls();
        setArr(this.imageUrls);
        this.imageUrlPrefix = myGardenDtlPicture.getImageUrlPrefix();
    }

    private void setArrUserId(String userid) {
        String user = userid;

        if(user.matches(".*\\|*.")){
            String[] strList = user.split("\\|");
            List<String> arrList = Arrays.asList(strList);
            setUserIds(arrList);
        }else;
    }

    public void setArr(String picture){
        String url = picture;
        if(url.matches(".*\\|*.")){
            String[] strArr = url.split("\\|");
            List<String> arr = Arrays.asList(strArr);
            setImageUrlArray(arr);
        }else;
    }
}
