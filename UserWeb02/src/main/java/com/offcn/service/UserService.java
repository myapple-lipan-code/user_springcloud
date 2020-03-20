package com.offcn.service;

import com.offcn.po.User;

import java.util.Map;

public interface UserService {
    //新增
     public void add(User user);
     //修改
    public  void update(User user);
     //删除
    public  void delete(Long id);
    //查询全部
    public Map<String,Object> findAll();
    //根据 id 查询
    public User findOne(Long id);
}
