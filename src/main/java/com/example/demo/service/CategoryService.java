package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category;

public interface  CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
