package com.example.demo.plantDic.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor   //벌레 이름 저장
public class PestSaveDto {

    private String pestName;
}
