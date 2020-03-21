package com.offcn;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  //服务注册发现客户端
@EnableHystrix  //自动配置Hystrix
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
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet =
                new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1); //系统启动时加载顺序
        servletRegistrationBean.addUrlMappings("/hystrix.stream");//路径
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}

