package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductModel {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
}
