package com.example.demo.plantDic.controller;

import com.example.demo.dto.Header;
import com.example.demo.plantDic.dto.request.FilterDto;
import com.example.demo.plantDic.dto.response.FilterResponseDto;
import com.example.demo.plantDic.dto.response.PestDto;
import com.example.demo.plantDic.dto.response.SearchDto;
import com.example.demo.plantDic.model.MyGardenDtl;
import com.example.demo.plantDic.model.Pest;
import com.example.demo.plantDic.repository.PestRepository;
import com.example.demo.plantDic.service.MyGardenClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j  /* 클라이언트 API */
public class OpenApiController {

    @Autowired
    MyGardenClientService myGardenClientService;

    @Autowired
    PestRepository pestRepository;

    //전체 조회.
    @GetMapping("collections/list")
    public Header<Page<SearchDto>> openDataListAll(@PageableDefault(size = 12) Pageable pageable) {
        Page<MyGardenDtl> page = myGardenClientService.findListAll(pageable);
        Page<SearchDto> searchDto = page.map(myGardenDtl -> new SearchDto(myGardenDtl));
        return Header.OK(searchDto);
    }

    //식물 랜덤 조회.
    @GetMapping("collections/random")
    public Header<Page<SearchDto>> openDataFindRandom(@PageableDefault(size = 12) Pageable pageable,
                                                      @RequestParam(value = "title") String title) {
        Page<MyGardenDtl> myGardenDtls = myGardenClientService.randomNum(pageable, title);
        if (myGardenDtls.getSize() == 0) {
            return Header.ERROR("검색하신 식물이 없습니다.");
        } else {
            Page<SearchDto> searchDto = myGardenDtls.map(myGardenDtl -> new SearchDto(myGardenDtl));
            return Header.OK(searchDto);
        }
    }

    //필터 조회.
    @GetMapping("collections/filter/list")
    public Header<Page<FilterResponseDto>> openDataFilterList(@PageableDefault(size = 12) Pageable pageable,
                                                              FilterDto filterDto) {
        Page<MyGardenDtl> myGardenDtls = myGardenClientService.findMyGardenDtlByFilter(pageable, filterDto);
        if (myGardenDtls.getSize() == 0) {
            return Header.ERROR("검색하신 식물이 없습니다.");
        }
        Page<FilterResponseDto> page = myGardenDtls.map(myGardenDtl -> new FilterResponseDto(myGardenDtl));
        return Header.OK(page);
    }

    //해충 조회
    @GetMapping("collections/pestSearch/{id}")
    public Header<PestDto> pestSearch(@PathVariable("id") Long id) {
        Pest pest = myGardenClientService.findByPest(id);
        PestDto pestDto = PestDto.of(pest);
        return Header.OK(pestDto);
    }
}

