package com.example.demo.plantDic.model;

import com.example.demo.plantDic.dto.request.PestSaveDto;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity @Getter
@Setter @Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Pest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pest_id")
    private Long id;

    private String pestCode;
    private String pestCodeNm;
    private String pestEng;
    @Column(length=1000)
    private String pestDetail;
    @Column(length=1000)
    private String pestPlantSymptom;
    @Column(length=1000)
    private String pestCtrl;
    private String pestMonth;
    private String pestUrl;
    private String pestImageName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myGardenDtl_id")
    private MyGardenDtl myGardenDtl;

    //해충 저장
    public void savePestOne(PestSaveDto pestSaveDto) {
        pestCode = "022001";
        pestEng = "Mite";
        pestDetail = "거미강 진드기목 응애과의 해충 1~2mm의 작은 크기로, 거미와 비슷한 외형을 가지고 있다. 식물의 줄기 혹은 잎에 기생해 수액을 흡수한다.";
        pestPlantSymptom = "주로 잎 뒷면과 어린 줄기에서 창궐하며, 그 주변으로 은색 거미줄이 발견된다. 응애가 수액을 흡수하게 되면 식물의 생장을 저해하며 시들음 현상이 발생한다. 대표적인 증상으로는 잎에 노란색 반점이 발견되며, 증상이 심해지면 잎 전체가 갈변하게 된다. 심해질 경우 식물 전체의 생장이 저하되어 고사될 수 있다.";
        pestCtrl = "응애를 방제하는 가장 확실한 방법은 살충제를 용법에 맞춰 희석해 사용하는 것이다. 일반적으로 5일마다 3~4회 분사하며, 내성이 생길 경우 약의 종류를 바꿔 사용한다. 실내에서 식물을 키우는 경우, 섣불리 살충제를 사용하기 어렵기 때문에 응애의 천적인 육식성 응애(칠레이리응애, 사막이리응애)를 이용한 친환경적 방제를 추천한다. 또한 방제작업과 함께, 식물 표면을 자주 물로 씻겨주는 것 역시 중요하다.";
        pestMonth = "5월, 7월, 8월";
        pestUrl = "https://grnr-s3.s3.ap-northeast-2.amazonaws.com/images/";
        pestImageName = "mite(1).jpg|mite(2).jpg";
    }

    public void savePestTwo(PestSaveDto pestSaveDto) {
        pestCode = "022002";
        pestEng = "Scale Insect";
        pestDetail = "곤충강 노린재목 깍지벌레상과의 해충 1~3mm의 작은 크기로, 밀랍과 같은 껍질을 가지고 있다. 식물의 잎이나 가지에 기생해 수액을 흡수한다.";
        pestPlantSymptom = "깍지벌레가 수액을 흡수하게 되면 식물의 생장을 저해하며 시들음 현상이 발생한다. 대표적인 증상으로는 그을음병과 고약병이 있다. 그을음병은 깍지벌레의 분비물로 인해 발병하며, 이 분비물에서 균이 자라면서 잎 전체에 검은 그을음을 닮은 피막이 잎 전체를 덮어 광합성을 방해한다. 고약병의 경우, 주로 식물의 가지에서 발병하며, 이 역시 깍지벌레의 분비물을 영양삼아 번식하는 포자가 가지에 침입해 성장을 방해한다.";
        pestCtrl = "깍지벌레는 두꺼운 껍질로 인해 방제가 상당히 어려운 해충이므로, 무엇보다 예방과 주기적인 체크가 중요하다. 특히 고온건조한 환경을 선호하기 때문에, 특히 겨울철 실내 공중습도 유지와 환기를 신경써야 한다. 방제를 위해서는, 물리적인 방법과 화학적인 방법(농약)를 함께 사용해야 한다. 물리적으로는, 먼저 식물에 알콜을 분사하여 껍질을 녹이고, 수건이나 물티슈 등으로 닦아낸다. 이 때, 식물에 상처가 나지 않도록 주의한다. 또한 이 작업과 함께, 식물 표면을 자주 물로 씻겨주는 것 역시 중요하다. 깍지벌레는 그 껍질 때문에, 실내용 친환경 농약으로는 방제가 어렵다. 따라서 화학적 방제를 할 때에는 실외 그늘진 곳에서, 강한 농약을 사용하는 것을 추천한다. 살포 후 3시간 이상 실외에 대기시켜 실내에 유독성분이 들어오지 않게 해준다.";
        pestMonth = "6월, 8월, 9월";
        pestUrl = "https://grnr-s3.s3.ap-northeast-2.amazonaws.com/images/";
        pestImageName = "scaleinsect.jpg";
    }

    public void savePestThree(PestSaveDto pestSaveDto) {
        pestCode = "022003";
        pestEng = "Whitefly";
        pestDetail = "곤충강 매미목 가루이과의 해충 약 1.4mm의 작은 크기로, 옅은 노란색의 몸 표면은 흰색 가루로 덮여있다. 식물의 수액을 흡수해 잎과 새순의 생장을 방해한다.";
        pestPlantSymptom = "온실가루이가 수액을 흡수하게 되면 식물의 생장을 저해하며 시들음 현상이 발생하고, 다양한 바이러스성 질환을 유발한다. 대표적인 증상으로는 그을음병과 황화병이 있다. 그을음병은 온실가루이의 분비물로 인해 발병하며, 이 분비물에서 균이 자라면서 잎 전체에 검은 그을음을 닮은 피막이 잎 전체를 덮어 광합성을 방해한다. 황화병은 온실가루이로 인한 바이러스 감염을 통해 발병하며, 엽록소 형성을 방해해 식물 전체가 노란색으로 물들게 된다.";
        pestCtrl = "온실가루이는 확산 속도가 빨라 방제가 상당히 어려운 해충이므로, 무엇보다 예방과 주기적인 체크가 중요하다. 주로 잎의 뒷면에서 수액을 흡수하기 때문에, 정기적으로 잎을 뒤집어 체크해야 한다. 발생 초기라면, 온실가루이용 살충제를 2~3회 반복해 살포함과 동시에 끈끈이 트랩을 사용해 방제할 수 있다. 실내에서 식물을 키우는 경우, 섣불리 살충제를 사용하기 어렵기 때문에, 온실가루이의 기생성 천적(온실가루이좀벌, 황온좀벌 등)을 이용한 친환경적 방제를 추천한다.";
        pestMonth = "8월, 9월, 10월";
        pestUrl = "https://grnr-s3.s3.ap-northeast-2.amazonaws.com/images/";
        pestImageName = "whitefly(1).jpg|whitefly(2).jpg";
    }

    public void savePestFour(PestSaveDto pestSaveDto) {
        pestCode = "022004";
        pestEng = "Aphid";
        pestDetail = "곤충강 노린재목 진딧물과의 해충 2~4mm의 작은 크기로, 물의 진액을 흡수, 말라죽게 만들며 이 해충이 배설하는 진로는 식물의 기공을 막고 곰팡이 등의 2차 피해를 유발한다.";
        pestPlantSymptom = "진딧물이 수액을 흡수하게 되면 식물의 생장을 저해하며 시들음 현상이 발생하고, 다양한 바이러스성 질환을 유발한다. 대표적인 증상으로는 그을음병이 있다. 그을음병은 진딧물의 분비물로 인해 발병하며, 이 분비물에서 균이 자라면서 잎 전체에 검은 그을음을 닮은 피막이 잎 전체를 덮어 광합성을 방해한다.";
        pestCtrl = "진딧물은 확산 속도가 빨라 방제가 상당히 어려운 해충이므로, 무엇보다 예방과 주기적인 체크가 중요하다. 효과적인 예방법으로는, 이미다클로프리드 계열의 약제를 토양에 살포, 그것을 흡수한 식물이 진딧물에 유해한 독성을 가지도록 하는 것이다. 이미 발생 후라면, 시중에 유통 중인 살충제를 용법에 맞게 희석해 사용하는 것이 가장 효과적이다. 실내에서 식물을 키우는 경우, 섣불리 살비제를 사용하기 어렵기 때문에 진딧물의의 기생성 천적(콜레마니진디벌)을 이용한 친환경적 방제를 추천한다. 우유를 스프레이로 살포해 진딧물의 기공을 막는 방법이나, 식초와 물을 3:7로 섞어 살포하는 방법도 있다. 식초물을 사용할 경우, 살포 후 물로 빠르게 씻어내야 한다.";
        pestMonth = "6월";
        pestUrl = "https://grnr-s3.s3.ap-northeast-2.amazonaws.com/images/";
        pestImageName = "Aphid.jpg";
    }

    public void savePestFive(PestSaveDto pestSaveDto) {
        pestCode = "022005";
        pestEng = "Thrips";
        pestDetail = "곤충강 총채벌레목 총체벌레과의 해충 약 1mm의 작은 크기로, 납작한 원통형의 몸에는 종에 따라 다른 크기의 날개를 가지고 있다. 대부분의 총채벌레는 식물 조직 내부에 기생, 서식하며, 식물의 수액을 흡수, 식물에 피해를 입히고 바이러스를 옮긴다.";
        pestPlantSymptom = "주로 잎과 열매에 피해를 입히며, 특히 어린 열매에 치명적이다. 피해를 입은 어린 잎에서는 작은 반점이 발견되며, 심하면 잎이 오그라들며 뒷면이 갈색으로 물들고, 겉면이 코르크화된다.  어린 열매에는 회색 또는 갈색 반점을 유발한다.";
        pestCtrl = "총채벌레는 피해 식물의 조직 내부에 산란하는 특성으로 읺해 방제가 까다로운 해충이다. 따라서 박멸하기 위해서는 '알-유충-번데기-성충'으로 이어지는 생태를 끊어야 한다. 매일 물 샤워와 알코올 살포를 통해 식물 위 개체(유충, 성충) 수를 줄인 후, 토양에 곰팡이(백강균) 기반 생물학적 약제를 살포해 번데기를 고사시킨다. 이 과정을 2~3주간 반복해 총채벌레를 박멸할 수 있다. 실내에서 식물을 키우는 경우, 섣불리 살충제를 사용하기 어렵기 때문에 총채벌레의 천적인 육식성 응애(오이이리응애, 지중해이리응애)를 이용한 친환경적 방제를 추천한다.";
        pestMonth = "6월";
        pestUrl = "https://grnr-s3.s3.ap-northeast-2.amazonaws.com/images/";
        pestImageName = "thrips.jpg";
    }

    public void update(PestSaveDto pestSaveDto) {
        pestCodeNm = pestSaveDto.getPestName();
    }
}
