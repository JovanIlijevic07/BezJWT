package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class OrderItemModel {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private int quantity;
    private BigDecimal price;
}
