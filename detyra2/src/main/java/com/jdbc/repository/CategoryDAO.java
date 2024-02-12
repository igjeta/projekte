package com.jdbc.repository;

import com.jdbc.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getCategories();
    Category getCategoryById(Integer id);
    Boolean createCategory(Category category);
}
