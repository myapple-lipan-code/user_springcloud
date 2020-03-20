package com.offcn.service.impl;

import com.offcn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service //进行spring的调用
public class HelloServiceImpl implements HelloService {

    @Autowired
    private DiscoveryClient discoveryClient; //服务查询工具 可以连接到EurekaServer

    //rest风格的接口 的模板工具类
    @Autowired
    private RestTemplate restTemplate;

    //从EurekaServer获取对应的服务的地址和端口
    public String getServerInfo(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("HelloProvider");
        if(instanceList!=null && instanceList.size()>0){
            //从实例集合中获取地址
            ServiceInstance instance = instanceList.get(0);
            //获取主机地址
            String host = instance.getHost();
            //获取端口号
            int port = instance.getPort();
            //返回地址
            return "http://"+host+":"+port;
        }
        return null;
    }
    @Override
    public String sayHello(){
        //进行服务提供者的调用
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(getServerInfo() + "/hello", String.class);
        String body = responseEntity.getBody();
        System. out .println("调用远程服务返回值: "+body);
        return  body;

    }


}
