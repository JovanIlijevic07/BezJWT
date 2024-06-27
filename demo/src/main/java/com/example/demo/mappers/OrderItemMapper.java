package com.example.demo.mappers;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderItem;
import com.example.demo.entities.Product;
import com.example.demo.models.OrderItemModel;

public class OrderItemMapper {

    public static OrderItemModel toModel(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }
        return OrderItemModel.builder()
                .id(orderItem.getId())
                .orderId(orderItem.getOrder() != null ? orderItem.getOrder().getId() : null)
                .productId(orderItem.getProduct() != null ? orderItem.getProduct().getId() : null)
                .quantity(orderItem.getQuantity())
                .price(orderItem.getPrice())
                .build();
    }

    public static OrderItem toEntity(OrderItemModel orderItemModel) {
        if (orderItemModel == null) {
            return null;
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemModel.getId());
        // Postavi narudžbinu ako je dostupna
        if (orderItemModel.getOrderId() != null) {
            Order order = new Order();
            order.setId(orderItemModel.getOrderId());
            orderItem.setOrder(order);
        }
        // Postavi proizvod ako je dostupan
        if (orderItemModel.getProductId() != null) {
            Product product = new Product();
            product.setId(orderItemModel.getProductId());
            orderItem.setProduct(product);
        }
        orderItem.setQuantity(orderItemModel.getQuantity());
        orderItem.setPrice(orderItemModel.getPrice());
        return orderItem;
    }
}
