package com.usrapi.demo.service;

import java.util.List;

import com.usrapi.demo.model.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}