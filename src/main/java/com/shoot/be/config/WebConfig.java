package com.shoot.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 요청에 대해 허용
                .allowedOrigins("http://localhost:3000") // 프론트엔드 origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 메서드
                .allowCredentials(true) // withCredentials 허용 시 반드시 true
                .allowedHeaders("*");
    }
}
