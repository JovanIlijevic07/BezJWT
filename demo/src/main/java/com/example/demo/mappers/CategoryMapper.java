package com.example.demo.mappers;

import com.example.demo.entities.Category;
import com.example.demo.models.CategoryModel;

public class CategoryMapper {

    public static CategoryModel toModel(Category category) {
        if (category == null) {
            return null;
        }
        return CategoryModel.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryModel categoryModel) {
        if (categoryModel == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryModel.getId());
        category.setName(categoryModel.getName());
        return category;
    }
}
