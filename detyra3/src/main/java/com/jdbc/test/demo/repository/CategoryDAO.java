package com.jdbc.test.demo.repository;

import com.jdbc.test.demo.entity.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> getCategories();

    Category getCategoryById(Integer id);

    Boolean createCategory(Category category);

    Boolean deleteCategory(Integer id);
}
