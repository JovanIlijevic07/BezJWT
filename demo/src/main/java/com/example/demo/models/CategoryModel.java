package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryModel {
    private Integer id;
    private String name;
}
