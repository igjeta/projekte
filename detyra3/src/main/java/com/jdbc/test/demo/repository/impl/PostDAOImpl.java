package com.jdbc.test.demo.repository.impl;

import com.jdbc.test.demo.entity.Post;
import com.jdbc.test.demo.exception.PostNotFoundException;
import com.jdbc.test.demo.exception.UserNotFoundException;
import com.jdbc.test.demo.mapper.PostMapper;
import com.jdbc.test.demo.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_POSTS_Q = "SELECT * FROM POSTS";
    private static final String GET_POST_BY_ID_Q = "SELECT * FROM POSTS WHERE id=?";
    private static final String GET_POSTS_BY_USER_ID_Q = "SELECT * FROM POSTS WHERE user_id=?";
    private static final String CREATE_POST_Q = "INSERT INTO POSTS (title,body,user_id) VALUES (?,?,?)";
    private static final String UPDATE_POST_Q = "UPDATE POSTS SET title=?,body=? WHERE id=?";

    @Override
    public List<Post> getPosts() {
        return jdbcTemplate.query(GET_POSTS_Q, new PostMapper());
    }

    @Override
    public Post getPostsById(Integer id) {
try {
        return jdbcTemplate.queryForObject(GET_POST_BY_ID_Q, new PostMapper(), id);
    }catch (
    EmptyResultDataAccessException ex){
        throw new PostNotFoundException("Post with id="+id+" does not exist");
    }
    }

    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        return jdbcTemplate.query(GET_POSTS_BY_USER_ID_Q, new PostMapper(), userId);
    }

    @Override
    public Boolean createPost(Post post) {
        var create = jdbcTemplate.update(CREATE_POST_Q, post.getTitle(), post.getBody(), post.getUser().getId());
        return create != -1;
    }

    @Override
    public Boolean updatePost(Integer id, Post post) {
        var update = jdbcTemplate.update(UPDATE_POST_Q, post.getTitle(), post.getBody(), id);
        return update != -1;
    }
}
