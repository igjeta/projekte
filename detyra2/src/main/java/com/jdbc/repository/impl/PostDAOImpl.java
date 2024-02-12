package com.jdbc.repository.impl;

import com.jdbc.entity.Post;
import com.jdbc.entity.User;
import com.jdbc.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PostDAOImpl implements PostDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private Integer id;
//    private String title;
//    private String body;
//    private User userId;
//    private LocalDate dateCreated;
//    private LocalDate dateModified;
    private static final String GET_ALL_POSTS_Q = "SELECT * FROM POSTS";

    private static final String GET_POST_BY_ID_Q = "SELECT * FROM POSTS WHERE id=?";

    private static final String CREATE_POST_Q = "INSERT INTO POSTS(title,body,user_id,date_created,date_modified) VALUES(?,?,?,?,?)";

    private static final String UPDATE_POST_Q = "UPDATE POSTS SET title=?,body=?,user_id=?, date_created=?,date_modified=? WHERE id=?";
    private static final String GET_POSTS_BY_USER_ID="SELECT * FROM POSTS WHERE user_id=?";

    @Override
    public List<Post> getPosts() {
        return jdbcTemplate.query(GET_ALL_POSTS_Q,new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public Post getPostsById(Integer id) {
        return jdbcTemplate.queryForObject(GET_POST_BY_ID_Q,new BeanPropertyRowMapper<>(Post.class),id);
    }

    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        return jdbcTemplate.query(GET_POSTS_BY_USER_ID,new BeanPropertyRowMapper<>(Post.class),userId);
    }

    @Override
    public Boolean createPost(Post post) {
       int create= jdbcTemplate.update(CREATE_POST_Q,post.getTitle(),post.getBody(),post.getUserId(),post.getDateCreated(),post.getDateModified());
        return create != -1;
    }

    @Override
    public Boolean updatePost(Integer id, Post post) {
        int update=jdbcTemplate.update(UPDATE_POST_Q,post.getTitle(),post.getBody(),post.getUserId(),post.getDateCreated(),post.getDateModified(),id);
        return update != -1;
    }
}
