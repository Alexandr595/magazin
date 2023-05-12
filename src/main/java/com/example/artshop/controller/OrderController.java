package com.example.artshop.controller;

import com.example.artshop.model.Order;
import com.example.artshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.findById(id)
                .map(existingOrder -> {
                    order.setId(existingOrder.getId());
                    return ResponseEntity.ok(orderService.save(order));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        return orderService.findById(id)
                .map(order -> {
                    orderService.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
// Этот класс использует аннотации @RestController и @RequestMapping,
// которые указывают на то, что этот класс является контроллером Spring,
// обрабатывающим HTTP-запросы по адресу /api/orders. Мы внедряем зависимость OrderService через конструктор
// с аннотацией @Autowired. Методы getAllOrders, getOrderById, createOrder,
// updateOrder и deleteOrder обрабатывают соответствующие HTTP-запросы и возвращают результаты
// с использованием методов OrderService.
