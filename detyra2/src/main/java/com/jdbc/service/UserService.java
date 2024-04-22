package com.jdbc.service;

import com.jdbc.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Integer id);
    Boolean createUser(User user);
    Boolean updateUser(Integer id, User user);
    Boolean deleteUser(Integer id);
}
