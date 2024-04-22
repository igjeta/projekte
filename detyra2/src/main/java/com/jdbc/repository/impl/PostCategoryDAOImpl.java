package com.jdbc.repository.impl;

import com.jdbc.entity.PostCategory;
import com.jdbc.repository.PostCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostCategoryDAOImpl implements PostCategoryDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String GET_POST_CATEGORIES_BY_POST_ID =
            "SELECT c.id, c.name, c.date_created, c.date_modified " +
                    "FROM Categories c JOIN Post_Categories pc ON c.id = pc.category_id " +
                    "WHERE pc.post_id = ?";
    public static final String GET_POST_CATEGORIES_BY_POST_ID_AND_CATEGORY_ID =
            "SELECT c.id, c.name, c.date_created, c.date_modified " +
                    "FROM Categories c JOIN Post_Categories pc ON c.id = pc.category_id " +
                    "WHERE pc.post_id = ? AND pc.category_id = ?";

    @Override
    public PostCategory getPostCategoryByPostId(Integer postId) {
        return jdbcTemplate.queryForObject(GET_POST_CATEGORIES_BY_POST_ID,new BeanPropertyRowMapper<>(PostCategory.class),postId);
    }

    @Override
    public PostCategory getPostCategoryByPostIdAndCategoryId(Integer postId, Integer categoryId) {
        return jdbcTemplate.queryForObject(GET_POST_CATEGORIES_BY_POST_ID_AND_CATEGORY_ID,new BeanPropertyRowMapper<>(PostCategory.class),postId,categoryId);
    }
}
