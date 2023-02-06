package com.example.demo.plantDic.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "nongsaro.openapi")
public class NongsaroProperties {
    private String key; //application-secret.properties에 있는 key값
}
