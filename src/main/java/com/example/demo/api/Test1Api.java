package com.example.demo.api;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test1Api {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    @Async
    public void test(@RequestParam("id") Integer id) {
        User user = userMapper.getUser(id);
        System.out.println("==========================");
        System.out.println(user.getUsername() + "  " + user.getPassword());
    }

    @RequestMapping("/get1")
    @Async
    public void get1() {
        User user = userMapper.getUser1();
        System.out.println("==========================");
        System.out.println(user.getUsername() + "  " + user.getPassword());
    }
    @RequestMapping("/get2")
    @Async
    public void get2() {
        User user = userMapper.getUser2();
        System.out.println("==========================");
        System.out.println(user.getUsername() + "  " + user.getPassword());
    }

    @RequestMapping("/test1")
    @Async
    public void test1(@RequestParam("id") String id) {
        userMapper.updateUserInfo(id);
    }

    @RequestMapping("/test3")
    public void test3(@RequestBody User user) {
        long t1 = System.currentTimeMillis();
        synchronized (this) {
            userMapper.saveUserInfo(user);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("-----------------" + (t2-t1));
    }

    @RequestMapping("/test2")
    @Async
    public void test2(@RequestBody User user) {
        long t1 = System.currentTimeMillis();
        userMapper.saveUserInfo(user);
        long t2 = System.currentTimeMillis();
        System.out.println("================" + (t2-t1));
    }

    @RequestMapping("/test4")
    public void test4(@RequestBody User user) {
        long t1 = System.currentTimeMillis();
        userMapper.saveUserInfo(user);
        long t2 = System.currentTimeMillis();
        System.out.println("================" + (t2-t1));
    }

}
