package com.dzt.test;

import com.dzt.dao.UserDao;
import com.dzt.dao.impl.UserDaoImpl;
import com.dzt.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("用戶名可以用！");
        }else{
            System.out.println("用户名已经存在了！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或者密码错误!登录失败");
        }else{
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"dzt123234","123456","dzt33@qq.com")));;
    }
}