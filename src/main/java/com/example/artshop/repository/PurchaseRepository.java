package com.example.artshop.repository;

import com.example.artshop.model.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Page<Purchase> findAll(Pageable pageable);
}