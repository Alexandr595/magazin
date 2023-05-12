package com.example.artshop.repository;

import com.example.artshop.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long> {
}
// Этот интерфейс PaintingRepository расширяет JpaRepository,
// предоставляя базовые методы для работы с сущностями Painting.
// В качестве параметров типа указаны класс сущности Painting и тип первичного ключа (Long).
// Аннотация @Repository указывает, что этот интерфейс является репозиторием Spring Data.