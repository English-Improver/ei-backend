package com.ei.config;

/*
  @author 86157
 * 2024/1/13
 */

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yitiansong
 */
@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NotNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("http://8.141.83.81:5500", "http://127.0.0.1:5500", "http://localhost:5500", "http://localhost:5173")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .exposedHeaders("Content-Disposition", "Content-Length")  // 暴露下载所需的响应头
                        .allowCredentials(true);
            }
        };
    }
}

