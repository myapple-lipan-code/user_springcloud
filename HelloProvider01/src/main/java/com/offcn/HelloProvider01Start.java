package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //允许客户端注册发现
public class HelloProvider01Start {
    public static void main(String[] args) {
        SpringApplication.run(HelloProvider01Start.class,args);
    }
}
