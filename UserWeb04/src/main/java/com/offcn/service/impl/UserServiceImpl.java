package com.offcn.service.impl;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService {

    @Override
    public void add(User user) {
        System.out.println("创建用户失败:触发熔断器");
    }

    @Override
    public void update(User user) {
        System.out.println("更新用户失败:触发熔断器");

    }

    @Override
    public void delete(Long id) {
        System.out.println("删除用户失败:触发熔断器");

    }

    @Override
    public Map<String, Object> findAll() {
        Map<String,Object> map= new HashMap<>();
        map.put( "list",new ArrayList<>());
        map.put( "version","调用远程服务失败,  熔断被触发 !");
        return map;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }
}
