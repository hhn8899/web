package com.dzt.service;

import com.dzt.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user 用户对象
     */
    public void registerUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 判断用户是否存在
     * @param username
     * @return true表示用户已存在，false表示用户名可以用。
     */
    public boolean existsUserName(String username);
}
