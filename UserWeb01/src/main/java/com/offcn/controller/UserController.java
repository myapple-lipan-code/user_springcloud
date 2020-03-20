package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public  class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String findAll(Model model){
        Map<String, Object> map = userService.findAll();
        String version=(String)  map.get("version");
        List<User> list=(List<User>) map.get("list");
        model.addAttribute("list",list);
        model.addAttribute("version",version);
        return "list";
    }


    //跳转到新增页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    //保存新增方法
    @PostMapping("/save")
    public String save(User user){
        userService.add(user);
        return "redirect:/";
    }

    //跳转到用户编辑页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        //获取指定id用户信息
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        //跳转到编辑页面
        return "edit";
    }

    //保存更新用户信息
    @RequestMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/";
    }

    //删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }
}