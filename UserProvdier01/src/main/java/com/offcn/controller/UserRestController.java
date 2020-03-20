package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * 获取全部用户数据
     * @return
     */
    @GetMapping("/")
    public Map<String,Object> findAll(){
        List<User> userList = userService.findAll();
        String version = "UserProvider01";
        HashMap<String, Object> map = new HashMap<>();
        map.put("list",userList);
        map.put("version",version);
        return map;
    }
    //获取指定用户id用户
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id){
        return userService.findOne(id);
    }
    //新增用户
    @PostMapping("/")
    public String add(@RequestBody User user){
        try {
            userService.add(user);
            return "add success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    //新增用户
    @PutMapping("/")
    public String update(@RequestBody User user){
        try {
            userService.update(user);
            return "update success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    //删除用户数据
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        try {
            userService.delete(id);
            return "delete success";
        } catch (Exception e) {
            e.printStackTrace();
            return  "error";
        }
    }
}