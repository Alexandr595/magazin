package com.example.artshop.repository;

import com.example.artshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
// Этот интерфейс OrderRepository расширяет JpaRepository,
// предоставляя базовые методы для работы с сущностями Order.
// В качестве параметров типа указаны класс сущности Order и тип первичного ключа (Long).
// Аннотация @Repository указывает, что этот интерфейс является репозиторием Spring Data.