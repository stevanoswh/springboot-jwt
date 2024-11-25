package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Category;

public interface  CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(UUID id);
    Category createCategory(Category category);
    Category updateCategory(UUID id, Category category);
    void deleteCategory(UUID id);
}
