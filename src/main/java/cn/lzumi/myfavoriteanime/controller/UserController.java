package cn.lzumi.myfavoriteanime.controller;

import cn.lzumi.myfavoriteanime.bean.User;
import cn.lzumi.myfavoriteanime.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userMapper.getUserById(id);
    }

    @GetMapping("/user")
    public User insertUser(User user){
        userMapper.insertUser(user);
        return user;
    }

    @GetMapping("/userupdate")
    public User updateUser(User user){
        userMapper.updateUser(user);
        return user;
    }
}
