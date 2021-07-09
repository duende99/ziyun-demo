package com.example.demo.mapper;

//import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    public void saveUserInfo(@Param("username") String username, @Param("password") String password);

    public void saveUserInfo2(@Param("username") String username, @Param("password") String password);

//    public void updateUserInfo(@Param("id") String id);
//
//    public User getUser(@Param("id") Integer id);
//    public User getUser1();
//    public User getUser2();
}
