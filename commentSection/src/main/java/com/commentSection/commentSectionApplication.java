package com.commentSection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.commentSection.mapper.**")
public class commentSectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(commentSectionApplication.class,args);
    }
}
