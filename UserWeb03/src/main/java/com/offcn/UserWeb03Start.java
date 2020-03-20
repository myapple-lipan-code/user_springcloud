package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  //服务注册发现客户端
public class UserWeb03Start {
    public static void main(String[] args) {
        SpringApplication.run(UserWeb03Start.class,args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        //设置读超时时间
        httpComponentsClientHttpRequestFactory.setReadTimeout(250);
        //设值连接超时时间
        httpComponentsClientHttpRequestFactory.setConnectTimeout(250);
        return  new RestTemplate(httpComponentsClientHttpRequestFactory);
    }
}
