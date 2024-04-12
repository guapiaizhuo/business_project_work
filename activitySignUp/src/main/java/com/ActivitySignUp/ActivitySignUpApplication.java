package com.ActivitySignUp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.ActivitySignUp.mapper.**")
@EnableDiscoveryClient
public class ActivitySignUpApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivitySignUpApplication.class,args);
    }
}
