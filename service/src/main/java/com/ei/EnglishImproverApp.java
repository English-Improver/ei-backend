package com.ei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Crean Culty
 * {@code @date} 2023/12/16
 */

@SpringBootApplication
@MapperScan("com.ei.mapper")
@EntityScan("pojo.model")
@EnableAsync
public class EnglishImproverApp {
    public static void main(String[] args) {
        // 启动springboot项目
        SpringApplication.run(EnglishImproverApp.class, args);
    }
}
