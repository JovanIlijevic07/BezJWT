package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;
    @CrossOrigin("*")
    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }
    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<ProductModel> createProduct(@Valid @RequestBody ProductModel productModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ProductModel createdProduct = productService.createProduct(productModel);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{productId}/categories/{categoryId}")
    public Product addCategoryToProduct(@PathVariable Integer productId, @PathVariable Integer categoryId) {
        return productService.addCategoryToProduct(productId, categoryId);
    }
}
