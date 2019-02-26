package com.demo.security.securitydemo.web.service.impl;

import com.demo.security.securitydemo.web.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting "+name);
        return null;
    }
}
