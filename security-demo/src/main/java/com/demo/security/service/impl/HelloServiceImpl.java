package com.demo.security.service.impl;

import com.demo.security.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting "+name);
        return null;
    }
}
