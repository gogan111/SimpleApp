package com.andrey.simpleApp.service;

import com.andrey.simpleApp.dao.UserDao;
import com.andrey.simpleApp.dao.UserDaoImpl;
import com.andrey.simpleApp.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public boolean deleteUser(int userId) {
        return userDao.deleteUser(userId);
    }
}
