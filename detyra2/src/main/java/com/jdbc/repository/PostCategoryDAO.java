package com.jdbc.repository;

import com.jdbc.entity.PostCategory;

public interface PostCategoryDAO {
    PostCategory getPostCategoryByPostId(Integer postId);
    PostCategory getPostCategoryByPostIdAndCategoryId(Integer postId, Integer
            categoryId);
}
