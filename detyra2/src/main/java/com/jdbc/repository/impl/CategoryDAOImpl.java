package com.jdbc.repository.impl;

import com.jdbc.entity.Category;
import com.jdbc.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_CATEGORIES="SELECT * FROM CATEGORIES";
    private static final String GET_CATEGORY_BY_ID="SELECT * FROM CATEGORIES WHERE id=?";
    private static final String CREATE_CATEGORY="INSERT INTO CATEGORIES (name,date_created,date_modified) VALUES (?,?,?)";
    @Override
    public List<Category> getCategories() {
        return jdbcTemplate.query(GET_CATEGORIES,new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public Category getCategoryById(Integer id) {
        return jdbcTemplate.queryForObject(GET_CATEGORY_BY_ID,new BeanPropertyRowMapper<>(Category.class),id);
    }

    @Override
    public Boolean createCategory(Category category) {
        int create=jdbcTemplate.update(CREATE_CATEGORY,category.getName(),category.getDateCreated(),category.getDateModified());
        return create != -1;
    }
}
