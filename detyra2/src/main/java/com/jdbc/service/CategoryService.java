package com.jdbc.service;

import com.jdbc.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(Integer id);
    Boolean createCategory(Category category);
}
