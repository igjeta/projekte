package com.jdbc.test.demo.service;

import com.jdbc.test.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategoryById(Integer id);

    Boolean createCategory(Category category);

    Boolean deleteCategory(Integer id);
}
