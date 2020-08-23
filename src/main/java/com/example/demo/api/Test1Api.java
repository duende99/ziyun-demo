package com.example.demo.api;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

@Api(value = "swagger Test1Api")
@RestController
public class Test1Api {

    @Autowired
    private UserMapper userMapper;


    @ApiOperation(value = "hello method test")
    @GetMapping("/test")
//    @RequestMapping("/test")
    @Async
    @ResponseBody
    public String test(@RequestParam("id") Integer id) {
        User user = userMapper.getUser(id);
        System.out.println("==========================");
        System.out.println(user.getUsername() + "  " + user.getPassword());
        return user.getUsername();
    }

    @GetMapping("/get1")
    @ResponseBody
    @Async
    public User get1() {
        User user = userMapper.getUser1();
        System.out.println("==========================");
        System.out.println(user.getUsername() + "  " + user.getPassword());
        return user;
    }

    @GetMapping("/get2")
    @Async
    public void get2() {
        User user = userMapper.getUser2();
        System.out.println("==========================");
        System.out.println(user.getUsername() + "  " + user.getPassword());
    }

    @GetMapping("/test1")
    @Async
    public void test1(@RequestParam("id") String id) {
        userMapper.updateUserInfo(id);
    }

    @GetMapping("/test3")
    public void test3(@RequestBody User user) {
        long t1 = System.currentTimeMillis();
        synchronized (this) {
            userMapper.saveUserInfo(user);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("-----------------" + (t2-t1));
    }

    @GetMapping("/test2")
    @Async
    public void test2(@RequestBody User user) {
        long t1 = System.currentTimeMillis();
        userMapper.saveUserInfo(user);
        long t2 = System.currentTimeMillis();
        System.out.println("================" + (t2-t1));
    }

    @GetMapping("/test4")
    public void test4(@RequestBody User user) {
        long t1 = System.currentTimeMillis();
        userMapper.saveUserInfo(user);
        long t2 = System.currentTimeMillis();
        System.out.println("================" + (t2-t1));
    }

}
