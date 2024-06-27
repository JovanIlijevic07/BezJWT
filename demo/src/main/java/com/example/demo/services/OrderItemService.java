package com.example.demo.services;

import com.example.demo.entities.OrderItem;
import com.example.demo.models.OrderItemModel;
import com.example.demo.repositories.IOrderItemRepository;
import com.example.demo.mappers.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private IOrderItemRepository orderItemRepository;

    public List<OrderItemModel> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(OrderItemMapper::toModel)
                .collect(Collectors.toList());
    }

    public OrderItemModel createOrderItem(OrderItemModel orderItemModel) {
        OrderItem orderItem = OrderItemMapper.toEntity(orderItemModel);
        orderItem = orderItemRepository.save(orderItem);
        return OrderItemMapper.toModel(orderItem);
    }

    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
