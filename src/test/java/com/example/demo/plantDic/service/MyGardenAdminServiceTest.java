package com.example.demo.plantDic.service;

import com.example.demo.plantDic.dto.request.PlantSaveDto;
import com.example.demo.plantDic.model.*;
import com.example.demo.plantDic.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MyGardenAdminServiceTest {

    @Autowired MyGardenAdminService myGardenAdminService;
    @Autowired MyGardenDtlRepository myGardenDtlRepository;

    @Autowired
    MyGardenDtlPictureRepository myGardenDtlPictureRepository;
    @Autowired
    PestOneRepository pestOneRepository;

    @Autowired
    PestTwoRepository pestTwoRepository;

    @Autowired
    PestThreeRepository pestThreeRepository;

    @Autowired
    PestFourRepository pestFourRepository;

    @Autowired
    PestFiveRepository pestFiveRepository;

    @Test
    public void myGarden_병충해_넣기() throws Exception {
        //given
        GardenDtl gardenDtl = new GardenDtl();
        gardenDtl.setCntntsSj("가울테리아");
        gardenDtl.setCntntsSj("드라세나 산데리아나 비렌스(개운죽)");
        gardenDtl.setCntntsSj("골드크레스트 '윌마'");
        gardenDtl.setCntntsSj("공작야자");
        gardenDtl.setCntntsSj("관음죽");
        gardenDtl.setCntntsSj("관엽베고니아");
        gardenDtl.setDlthtsCodeNm("응애, 깍지");
        gardenDtl.setDlthtsCodeNm("응애, 깍지");
        gardenDtl.setDlthtsCodeNm("응애, 깍지");
        gardenDtl.setDlthtsCodeNm("응애, 깍지");
        gardenDtl.setDlthtsCodeNm("응애, 깍지");
        gardenDtl.setDlthtsCodeNm("응애, 깍지");

        MyGardenDtl myGardenDtl = new MyGardenDtl();
        myGardenDtl.setCntntsSj("가울테리아");
        gardenDtl.setCntntsSj("관엽베고니아");
        gardenDtl.setCntntsSj("공작야자");
        gardenDtl.setCntntsSj("관음죽");
    }

    @Test
    public void 관리자용_저장() throws Exception {
        //given
        PlantSaveDto plantSaveDto = new PlantSaveDto();
        plantSaveDto.setCntntsSj("응가테리아");
        plantSaveDto.setFlIng("꽃말은 응가"); //name
        plantSaveDto.setPestCodeNm("응애, 깍지벌레");

        //when
        myGardenAdminService.save(plantSaveDto);

        //then
    }
}