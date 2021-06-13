package com.andrey.simpleApp.service;

import com.andrey.simpleApp.domain.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    boolean updateUser(User user);

    List<User> getUsers();

    boolean deleteUser(int userId);
}
