package com.example.demo.mappers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;

public class ProductMapper {

    public static ProductModel toModel(Product product) {
        if (product == null) {
            return null;
        }
        return ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .build();
    }

    public static Product toEntity(ProductModel productModel) {
        if (productModel == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productModel.getId());
        product.setName(productModel.getName());
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());
        // Postavi kategoriju ako je dostupna
        if (productModel.getCategoryId() != null) {
            Category category = new Category();
            category.setId(productModel.getCategoryId());
            product.setCategory(category);
        }
        return product;
    }
}
