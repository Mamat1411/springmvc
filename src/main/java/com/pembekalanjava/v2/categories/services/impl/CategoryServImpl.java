package com.pembekalanjava.v2.categories.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalanjava.v2.categories.entities.Category;
import com.pembekalanjava.v2.categories.repositories.CategoryRepository;
import com.pembekalanjava.v2.categories.services.CategoryService;

@Service
public class CategoryServImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    
}
