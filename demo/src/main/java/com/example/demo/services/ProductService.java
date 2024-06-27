package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toModel)
                .collect(Collectors.toList());
    }

    public ProductModel createProduct(ProductModel productModel) {
        Product product = ProductMapper.toEntity(productModel);
        product = productRepository.save(product);
        return ProductMapper.toModel(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
