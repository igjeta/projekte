package com.jdbc.service.impl;

import com.jdbc.entity.Post;
import com.jdbc.repository.PostDAO;
import com.jdbc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDAO postDAO;

    @Override
    public List<Post> getPosts() {
        return postDAO.getPosts();
    }

    @Override
    public Post getPostsById(Integer id) {
        return postDAO.getPostsById(id);
    }

    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        return postDAO.getPostsByUserId(userId);
    }

    @Override
    public Boolean createPost(Post post) {
        return postDAO.createPost(post);
    }

    @Override
    public Boolean updatePost(Integer id, Post post) {
        return postDAO.updatePost(id,post);
    }
}
