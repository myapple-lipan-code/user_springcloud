package com.offcn.service.impl;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;



    public String getServerInfo(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("UserProvider");
        if(instanceList!=null && instanceList.size()>0){
            ServiceInstance serviceInstance = instanceList.get(0);
            String host = serviceInstance.getHost();//主机地址
            int port = serviceInstance.getPort();//端口地址
            return  "http://"+host+":"+port;  //http://localhost:9001
        }
        return  null;
    }

    @Override
    public void add(User user) {
        //使用post请求
        String s = restTemplate.postForObject(getServerInfo() + "/user/", user, String.class);
        System.out.println("新增用户:"+s);
    }

    @Override
    public void update(User user) {
        restTemplate.put(getServerInfo()+"/user/",user);
        System.out.println("更新用户");
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(getServerInfo()+"/user/"+id);
    }

    @Override
    public Map<String,Object> findAll() {
        Map forObject = restTemplate.getForObject(getServerInfo() + "/user/", Map.class);
        return forObject;
    }

    @Override
    public User findOne(Long id) {
        return restTemplate.getForObject(getServerInfo()+ "/user/"+id,User. class);
    }
}
