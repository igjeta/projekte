package com.jdbc.test.demo.service;

import com.jdbc.test.demo.entity.PostCategory;

public interface PostCategoryService {
    PostCategory getPostCategoryByPostId(Integer postId);

    PostCategory getPostCategoryByPostIdAndCategoryId(Integer postId, Integer categoryId);
}
