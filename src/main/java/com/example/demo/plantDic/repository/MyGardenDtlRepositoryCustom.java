package com.example.demo.plantDic.repository;

import com.example.demo.plantDic.dto.request.FilterDto;
import com.example.demo.plantDic.model.MyGardenDtl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyGardenDtlRepositoryCustom {
    Page<MyGardenDtl> searchFilter(Pageable pageable, FilterDto filter);
}
