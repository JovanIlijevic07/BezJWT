package com.example.demo.controllers;

import com.example.demo.models.OrderItemModel;
import com.example.demo.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@CrossOrigin("*")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;
    @CrossOrigin("*")
    @GetMapping
    public List<OrderItemModel> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }
    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<OrderItemModel> createOrderItem(@Valid @RequestBody OrderItemModel orderItemModel) {
        OrderItemModel createdOrderItem = orderItemService.createOrderItem(orderItemModel);
        return new ResponseEntity<>(createdOrderItem, HttpStatus.CREATED);
    }
    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
