package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.models.OrderModel;
import com.example.demo.repositories.IOrderRepository;
import com.example.demo.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::toModel)
                .collect(Collectors.toList());
    }

    public OrderModel createOrder(OrderModel orderModel) {
        Order order = OrderMapper.toEntity(orderModel);
        order = orderRepository.save(order);
        return OrderMapper.toModel(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
