package com.jdbc.service.impl;

import com.jdbc.entity.PostCategory;
import com.jdbc.repository.PostCategoryDAO;
import com.jdbc.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    @Autowired
    PostCategoryDAO postCategoryDAO;

    @Override
    public PostCategory getPostCategoryByPostId(Integer postId) {
        return postCategoryDAO.getPostCategoryByPostId(postId);
    }

    @Override
    public PostCategory getPostCategoryByPostIdAndCategoryId(Integer postId, Integer categoryId) {
        return postCategoryDAO.getPostCategoryByPostIdAndCategoryId(postId,categoryId);
    }
}
