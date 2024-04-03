package com.ActivityDetails;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.ActivityDetails.mapper.**")
@EnableDiscoveryClient
public class ActivityDetailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivityDetailsApplication.class,args);
    }
}
