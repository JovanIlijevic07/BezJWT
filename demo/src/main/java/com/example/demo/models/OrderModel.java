package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class OrderModel {
    private Integer id;
    private Integer userId;
    private Date orderDate;
    private String status;
}
