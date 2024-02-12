package com.jdbc.test.demo.repository.impl;

import com.jdbc.test.demo.entity.Category;
import com.jdbc.test.demo.exception.CategoryNotFoundException;
import com.jdbc.test.demo.exception.UserNotFoundException;
import com.jdbc.test.demo.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_CATEGORIES_Q = "SELECT * FROM CATEGORIES";
    private static final String GET_CATEGORY_BY_ID_Q = "SELECT * FROM CATEGORIES WHERE id=?";
    private static final String CREATE_CATEGORY_Q = "INSERT INTO CATEGORIES (name) VALUES (?)";
    private static final String DELETE_CATEGORY_Q = "DELETE FROM CATEGORIES WHERE id=?";

    @Override
    public List<Category> getCategories() {
        return jdbcTemplate.query(GET_CATEGORIES_Q, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public Category getCategoryById(Integer id) {
        try {
        return jdbcTemplate.queryForObject(GET_CATEGORY_BY_ID_Q, new BeanPropertyRowMapper<>(Category.class), id);
    }catch (
    EmptyResultDataAccessException ex){
        throw new CategoryNotFoundException("Category with id="+id+" does not exist");
    }
    }

    @Override
    public Boolean createCategory(Category category) {
        var create = jdbcTemplate.update(CREATE_CATEGORY_Q, category.getName());
        return create != -1;
    }

    @Override
    public Boolean deleteCategory(Integer id) {
        var delete=jdbcTemplate.update(DELETE_CATEGORY_Q,id);
        return delete!=-1;
    }
}
