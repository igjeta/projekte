package com.jdbc.test.demo.repository;

import com.jdbc.test.demo.entity.PostCategory;

public interface PostCategoryDAO {

    PostCategory getPostCategoryByPostId(Integer postId);

    PostCategory getPostCategoryByPostIdAndCategoryId(Integer postId, Integer categoryId);
}
