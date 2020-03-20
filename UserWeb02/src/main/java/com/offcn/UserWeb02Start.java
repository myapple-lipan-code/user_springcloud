package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  //服务注册发现客户端
public class UserWeb02Start {
    public static void main(String[] args) {
        SpringApplication.run(UserWeb02Start.class,args);
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
