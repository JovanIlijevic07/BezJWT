package com.example.demo.mappers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductModel toModel(Product entity) {
        return ProductModel.builder()
                .name(entity.getName()).build();
    }

    public static List<ProductModel> toModelList(List<Product> entities) {
        var list = new ArrayList<ProductModel>();

        for (var entity : entities) {
            list.add(toModel(entity));
        }

        return list;
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
        return product;
    }
}
