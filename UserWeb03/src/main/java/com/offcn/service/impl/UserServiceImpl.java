package com.offcn.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
   /* @Autowired
    private DiscoveryClient discoveryClient;*/
   //支持负载均衡的客户端
   /*@Autowired
   private LoadBalancerClient loadBalancerClient;*/

    @Autowired
    private RestTemplate restTemplate;



    public String getServerInfo(){
      return "http://USERPROVIDER";

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
    @HystrixCommand(fallbackMethod = "findAllFallback")
    public Map<String,Object> findAll() {
        Map forObject = restTemplate.getForObject(getServerInfo() + "/user/", Map.class);
        return forObject;
    }

    /**
     * 触发熔断  快速返回值
     * 默认熔断超时时间是1000ms
     * @return
     */
    public Map<String,Object> findAllFallback(){
        Map<String,Object> map = new HashMap();
        map.put("version","熔断被触发，远程调用失败");
        map.put("list",new ArrayList<>());
            return  map;
    }


    @Override
    public User findOne(Long id) {
        return restTemplate.getForObject(getServerInfo()+ "/user/"+id,User. class);
    }
}
