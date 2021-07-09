package com.example.demo.api;


import com.example.demo.mapper.UserMapper;
import com.example.demo.service.Test01Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class Test2Api {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private Test01Service test01Service;

    @RequestMapping("/test2")
    @Transactional
    public String test2() {
        userMapper.saveUserInfo("du","123");
//        int i = 1/0;
//        test01Service.saveUserInfo2(",","");
        test3();
        return "success";
    }

    @Transactional
    public String test3() {
//        userMapper.saveUserInfo("du","123");
        int i = 1/0;
        test01Service.saveUserInfo2("1");
        return "success";
    }
}