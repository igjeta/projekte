package com.jdbc.test.demo.service;

import com.jdbc.test.demo.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();

    Post getPostsById(Integer id);

    List<Post> getPostsByUserId(Integer userId);

    Boolean createPost(Post post);

    Boolean updatePost(Integer id, Post post);
}
