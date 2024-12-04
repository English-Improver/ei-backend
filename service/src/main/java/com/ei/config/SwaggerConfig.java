package com.ei.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yitiansong
 */
@Configuration
public class SwaggerConfig {
    @Bean
    GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder().group("com.ei.controllers").pathsToMatch("/**").build();
    }

    @Bean
    OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("英语个人住手 API").version("1.0.0"));
    }
}


