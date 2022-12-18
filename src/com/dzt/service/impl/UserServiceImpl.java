package com.dzt.service.impl;

import com.dzt.dao.UserDao;
import com.dzt.dao.impl.UserDaoImpl;
import com.dzt.pojo.User;
import com.dzt.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUserName(String username) {
        if(userDao.queryUserByUsername(username) == null){
            //等于null，在数据库没有插到，说明可以用
            return false;
        }
        return true;
    }
}
