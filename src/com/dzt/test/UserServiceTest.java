package com.dzt.test;

import com.dzt.pojo.User;
import com.dzt.service.UserService;
import com.dzt.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"wlwwlw","123456","wlwwlw@qq.com"));
        userService.registerUser(new User(null,"xsfsass","123456","sdfasdf@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin","32223")));
        System.out.println(userService.login(new User(null,"23","admin","32223")));
    }

    @Test
    public void existsUserName() {
        if(userService.existsUserName("admin")){
            System.out.println("用户名已经存在!");
        }else{
            System.out.println("用户名可以用用！");
        }
    }
}