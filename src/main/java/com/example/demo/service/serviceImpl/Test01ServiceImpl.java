package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.Test01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class Test01ServiceImpl implements Test01Service {

    @Autowired
    private UserMapper userMapper;

    @Override
//    @Cacheable(value = "name", key = "du")
    @Cacheable(value = "name")
    public String saveUserInfo2(String id) {
//        userMapper.saveUserInfo2("shen", "123");
        System.out.println("======= cache");
        return "123";
    }
}
