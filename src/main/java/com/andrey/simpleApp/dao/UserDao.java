package com.andrey.simpleApp.dao;

import com.andrey.simpleApp.domain.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    boolean updateUser(User user);

    List<User> getUsers();

    boolean deleteUser(int userId);

    User getUser(int id);
}
