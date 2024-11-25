package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Category> getAllCategories() { // READ All
        return repo.findAll();
    }

    @Override
    public Category getCategoryById(UUID id) { // READ by id
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found category with id: " + id));
    }

    @Override
    public Category createCategory(Category category) {
        return repo.save(category); // C / Create
    }

    @Override
    public Category updateCategory(UUID id, Category category) {
        Category existCategory = getCategoryById(id);
        existCategory.setName(category.getName()); // class untuk iterate setiap field dari class yang mau diupdate, dan ganti valuenya kalo misalnya dia ada

        return repo.save(existCategory);
    }

    @Override
    public void deleteCategory(UUID id) {
        getCategoryById(id);
        repo.deleteById(id);
    }
    
}
// CRUD