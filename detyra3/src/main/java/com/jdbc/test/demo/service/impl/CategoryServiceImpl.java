package com.jdbc.test.demo.service.impl;

import com.jdbc.test.demo.entity.Category;
import com.jdbc.test.demo.repository.CategoryDAO;
import com.jdbc.test.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;
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

    @Override
    public Boolean deleteCategory(Integer id) {
        return categoryDAO.deleteCategory(id);
    }

}
