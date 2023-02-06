package com.example.demo.plantDic.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter @Setter @Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"myGardenDtl"})
public class MyGardenDtlPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "myGardenDtlPicture_id")
    private Long id;

    //인스타 아이디 + 링크 -> 인스타 회원 링크
    private String userid;

    //인스타 링크
    private String userLink;

    //이미지 저장 주소 + 인스타 아이디.jpg -> 사진 링크
    @Column(length = 1000)
    private String imageUrls;

    //이미지 저장 주소
    @Column(length = 1000)
    private String imageUrlPrefix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myGardenDtl_id")
    private MyGardenDtl myGardenDtl;

    public void updateImageUrl(String imageUrl){
        this.userid = imageUrl;
    }
}
