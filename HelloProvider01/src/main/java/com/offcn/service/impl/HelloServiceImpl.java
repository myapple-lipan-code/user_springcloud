package com.offcn.service.impl;

import com.offcn.service.HelloService;
import org.springframework.stereotype.Service;

//REST风格的注解
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "hello Eureka";
    }
}
