package com.offcn;

import com.offcn.filter.AccessZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy  //zuul代理类
public class ZuulGateWayStart {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayStart.class,args);
    }

    @Bean
    public AccessZuulFilter accessZuulFilter(){
        return new AccessZuulFilter();
    }
}
