package com.jdbc.service.impl;

import com.jdbc.entity.Category;
import com.jdbc.repository.CategoryDAO;
import com.jdbc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    @Override
    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryDAO.getCategoryById(id);
    }

    @Override
    public Boolean createCategory(Category category) {
        return categoryDAO.createCategory(category);
    }
}
