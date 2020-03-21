package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //hystrixDashBoard的配置类
public class NetflixHystrixDashBoardStart {
    public static void main(String[] args) {
        SpringApplication.run(NetflixHystrixDashBoardStart.class,args);
    }
}
