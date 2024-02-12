package com.jdbc.repository;

import com.jdbc.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    User getUserById(Integer id);
    Boolean createUser(User user);
    Boolean updateUser(Integer id, User user);
    Boolean deleteUser(Integer id);

}
