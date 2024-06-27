package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.models.CategoryModel;
import com.example.demo.repositories.ICategoryRepository;
import com.example.demo.mappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    public List<CategoryModel> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toModel)
                .collect(Collectors.toList());
    }

    public CategoryModel createCategory(CategoryModel categoryModel) {
        Category category = CategoryMapper.toEntity(categoryModel);
        category = categoryRepository.save(category);
        return CategoryMapper.toModel(category);
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
