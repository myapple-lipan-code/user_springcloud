package com.offcn.service;

import com.offcn.config.FeignConfig;
import com.offcn.po.User;
import com.offcn.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "ZUULGATEWAY" ,configuration = FeignConfig.class,fallback = UserServiceImpl.class)
public interface UserService {
    //新增
    @PostMapping("/s3/user/?token=apple")
     public void add(User user);
     //修改
    @PutMapping("/s3/user/?token=apple")
    public  void update(User user);
     //删除
    @DeleteMapping("/s3/user/{id}?token=apple")
    public  void delete(@PathVariable("id") Long id);
    //查询全部
    @GetMapping("/s3/user/?token=apple")
    public Map<String,Object> findAll();
    //根据 id 查询
    @GetMapping("/s3/user/{id}?token=apple")
    public User findOne(@PathVariable("id") Long id);
}
