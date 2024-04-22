package com.jdbc.repository.impl;

import com.jdbc.entity.User;
import com.jdbc.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_USERS_Q = "SELECT * FROM USERS";

    private static final String GET_USER_BY_ID_Q = "SELECT * FROM USERS WHERE id=?";

    private static final String CREATE_USER_Q = "INSERT INTO USERS(username,email,password,date_created,date_modified) VALUES(?,?,?,?,?)";

    private static final String UPDATE_USER_Q = "UPDATE USERS SET username=?,email=?,password=?,date_created=?,date_modified=? WHERE id=?";

    private static final String DELETE_USER_Q ="DELETE FROM USERS WHERE id=?";
    @Override
    public List<User> getUsers() {
        return jdbcTemplate
                .query(GET_ALL_USERS_Q
                        ,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User getUserById(Integer id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_Q,
                new BeanPropertyRowMapper<>(User.class),
                id);
    }

    @Override
    public Boolean createUser(User user) {
        int create=jdbcTemplate.update(CREATE_USER_Q,user.getUsername(),user.getEmail(),user.getPassword(),user.getDateCreated(),user.getDateModified());
        return create != -1;
    }

    @Override
    public Boolean updateUser(Integer id, User user) {
        int update=jdbcTemplate.update(UPDATE_USER_Q,new Object[]{
                user.getUsername(),user.getEmail(),user.getPassword(),user.getDateCreated(),user.getDateModified(),id
        });
        return update != -1;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        int delete=jdbcTemplate.update(DELETE_USER_Q,id);
        return delete != -1;
    }
}
