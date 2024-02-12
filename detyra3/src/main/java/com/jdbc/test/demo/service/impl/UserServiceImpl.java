package com.jdbc.test.demo.service.impl;

import com.jdbc.test.demo.entity.User;
import com.jdbc.test.demo.repository.UserDAO;
import com.jdbc.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }

    @Override
    public Boolean createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public Boolean updateUser(Integer id, User user) {
        return userDAO.updateUser(id, user);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userDAO.deleteUser(id);
    }
}
