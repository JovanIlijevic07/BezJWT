package com.example.demo.mappers;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.models.OrderModel;

public class OrderMapper {

    public static OrderModel toModel(Order order) {
        if (order == null) {
            return null;
        }
        return OrderModel.builder()
                .id(order.getId())
                .userId(order.getUser() != null ? order.getUser().getId() : null)
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .build();
    }

    public static Order toEntity(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderModel.getId());
        // Postavi korisnika ako je dostupan
        if (orderModel.getUserId() != null) {
            User user = new User();
            user.setId(orderModel.getUserId());
            order.setUser(user);
        }
        order.setOrderDate(orderModel.getOrderDate());
        order.setStatus(orderModel.getStatus());
        return order;
    }
}
