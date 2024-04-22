package com.jdbc.service;

import com.jdbc.entity.PostCategory;

public interface PostCategoryService {
    PostCategory getPostCategoryByPostId(Integer postId);
    PostCategory getPostCategoryByPostIdAndCategoryId(Integer postId, Integer
            categoryId);
}
