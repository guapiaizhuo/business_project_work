package com.activityRelease;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@MapperScan(basePackages = "com.activityRelease.mapper.**")
@EnableFeignClients
@EnableDiscoveryClient
public class ActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class,args);
    }


}
