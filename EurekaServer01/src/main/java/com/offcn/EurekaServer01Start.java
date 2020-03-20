package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   //EurekaServer的自动装配的配置类注解  把当前的启动类作为EurekaServer的启动类
public class EurekaServer01Start {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer01Start.class,args);
    }
}
