package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  //服务注册发现客户端
public class HelloConsumer01Start {
    public static void main(String[] args) {
        SpringApplication.run(HelloConsumer01Start.class,args);
    }
    //在主启动类中实例化RestTemplate
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
