package com.example.artshop.service;

import com.example.artshop.model.Order;
import com.example.artshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
//В этом классе используется аннотация @Service, которая указывает на то,
// что этот класс является сервисным компонентом Spring.
// Внедряем зависимость OrderRepository через конструктор с аннотацией @Autowired.
// Методы findAll, findById, save и deleteById выполняют основные операции над сущностями Order
// с использованием методов из OrderRepository.