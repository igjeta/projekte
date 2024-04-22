package com.jdbc.test.demo.repository.impl;

import com.jdbc.test.demo.entity.User;
import com.jdbc.test.demo.exception.UserNotFoundException;
import com.jdbc.test.demo.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    // create jdbc template object
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // start sql queries
    private static final String GET_USERS_Q = "SELECT * FROM USERS";
    private static final String GET_USER_BY_ID_Q = "SELECT * FROM USERS WHERE id=?";
    private static final String CREATE_USER_Q = "INSERT INTO USERS (username,email,password) VALUES (?,?,?)";
    private static final String UPDATE_USER_Q = "UPDATE USERS SET username=?, email=?, password=? WHERE id=?";
    private static final String DELETE_USER_Q = "DELETE FROM USERS WHERE id=?";
    // end sql queries

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query(GET_USERS_Q, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User getUserById(Integer id) {
        try {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_Q, new BeanPropertyRowMapper<>(User.class),id);
    }catch (EmptyResultDataAccessException ex){
        throw new UserNotFoundException("User with id="+id+" does not exist");
    }
    }

    @Override
    public Boolean createUser(User user) {
        var create = jdbcTemplate.update(CREATE_USER_Q, user.getUsername(), user.getEmail(), user.getPassword());
        return create != -1;
    }

    @Override
    public Boolean updateUser(Integer id, User user) {
        var update = jdbcTemplate.update(UPDATE_USER_Q, user.getUsername(), user.getEmail(), user.getPassword(), id);
        return update != -1;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        var delete = jdbcTemplate.update(DELETE_USER_Q, id);
        return delete != -1;
    }
}
