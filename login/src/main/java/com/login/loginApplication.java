package com.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class loginApplication {
    public static void main(String[] args) {
        SpringApplication.run(loginApplication.class,args);
    }
}
