package com.dzt.dao;

import com.dzt.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null，说明用户不存在，反之就存在
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码进行查询
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null，说明用户名或者密码错误，反之就是正确的。
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user 用户对象
     * @return 返回-1表示保存失败，其他表示保存成功
     */
    public int saveUser(User user);
}
