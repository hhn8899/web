package com.dzt.web;

import com.dzt.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("this is login()方法!");
    }

    public void regit(){
        System.out.println("this is regist()方法！");
    }

    public void updateUser(){
        System.out.println("this is a updateUser()方法！");
    }

    public static void main(String[] args) {
        String action = "";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            method.invoke(new UserServletTest());
            System.out.println(method);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

