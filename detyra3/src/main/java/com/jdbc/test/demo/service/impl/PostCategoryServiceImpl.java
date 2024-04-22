package com.jdbc.test.demo.service.impl;

import com.jdbc.test.demo.entity.PostCategory;
import com.jdbc.test.demo.repository.PostCategoryDAO;
import com.jdbc.test.demo.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    @Autowired
    private PostCategoryDAO postCategoryDAO;

    @Override
    public PostCategory getPostCategoryByPostId(Integer postId) {
        return postCategoryDAO.getPostCategoryByPostId(postId);
    }

    @Override
    public PostCategory getPostCategoryByPostIdAndCategoryId(Integer postId, Integer categoryId) {
        return postCategoryDAO.getPostCategoryByPostIdAndCategoryId(postId, categoryId);
    }
}
