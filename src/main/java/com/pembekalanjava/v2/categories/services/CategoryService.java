package com.pembekalanjava.v2.categories.services;

import java.util.List;

import com.pembekalanjava.v2.categories.entities.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category saveCategory(Category category);
}
