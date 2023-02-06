package com.example.demo.plantDic.service;

import com.example.demo.plantDic.dto.request.FilterDto;
import com.example.demo.plantDic.model.MyGardenDtl;
import com.example.demo.plantDic.model.MyGardenDtlPicture;
import com.example.demo.plantDic.model.Pest;
import com.example.demo.plantDic.repository.MyGardenDtlPictureRepository;
import com.example.demo.plantDic.repository.MyGardenDtlRepository;
import com.example.demo.plantDic.repository.PestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyGardenClientService {

    @Autowired
    MyGardenDtlRepository myGardenDtlRepository;

    @Autowired
    MyGardenDtlPictureRepository myGardenDtlPictureRepository;

    @Autowired
    PestRepository pestRepository;

    @Value("${aws.s3.image.url.prefix}")
    String imageUrlPrefix;

    /* 클라이언트 api */
    //식물 전체 조회
    @Transactional(readOnly = true)
    public Page<MyGardenDtl> findListAll(Pageable pageable) {
        return myGardenDtlRepository.findAll(pageable);
    }

    //랜덤 조회(전체)
    @Transactional(readOnly = true)
    public Page<MyGardenDtl> randomNum(Pageable pageable, String title) {
        return myGardenDtlRepository.findName(pageable, title);
    }

    //필터 조회
    @Transactional(readOnly = true)
    public Page<MyGardenDtl> findMyGardenDtlByFilter(Pageable pageable, FilterDto filterDto) {
        return myGardenDtlRepository.searchFilter(pageable, filterDto);
    }

    //사진 조회
    @Transactional(readOnly = true)
    public MyGardenDtlPicture findMyPic(Long id){
        return myGardenDtlPictureRepository.getById(id);
    }

    //해충 조회
    public Pest findByPest(Long id) {
        return pestRepository.getById(id);
    }
}
