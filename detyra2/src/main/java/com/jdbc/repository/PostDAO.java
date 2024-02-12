package com.jdbc.repository;

import com.jdbc.entity.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getPosts();
    Post getPostsById(Integer id);
    List<Post> getPostsByUserId(Integer userId);
    Boolean createPost(Post post);
    Boolean updatePost(Integer id, Post post);

}
