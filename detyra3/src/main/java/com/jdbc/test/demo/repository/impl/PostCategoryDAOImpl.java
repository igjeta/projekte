package com.jdbc.test.demo.repository.impl;

import com.jdbc.test.demo.entity.PostCategory;
import com.jdbc.test.demo.repository.PostCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostCategoryDAOImpl implements PostCategoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_POST_CATEGORIES_BY_POST_ID = "SELECT * FROM Post_Categories WHERE post_id =?";
    private static final String GET_POST_CATEGORIES_BY_POST_ID_AND_CATEGORY_ID = "SELECT * FROM Post_Categories WHERE post_id =? AND category_id = ?";


    @Override
    public PostCategory getPostCategoryByPostId(Integer postId) {
        return jdbcTemplate.queryForObject(GET_POST_CATEGORIES_BY_POST_ID, new BeanPropertyRowMapper<>(PostCategory.class), postId);
    }

    @Override
    public PostCategory getPostCategoryByPostIdAndCategoryId(Integer postId, Integer categoryId) {
        return jdbcTemplate.queryForObject(GET_POST_CATEGORIES_BY_POST_ID_AND_CATEGORY_ID, new BeanPropertyRowMapper<>(PostCategory.class), postId, categoryId);
    }
}
