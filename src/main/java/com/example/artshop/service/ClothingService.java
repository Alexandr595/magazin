package com.example.artshop.service;

import com.example.artshop.model.Clothing;
import com.example.artshop.repository.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothingService {

    private final ClothingRepository clothingRepository;

    @Autowired
    public ClothingService(ClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }

    public List<Clothing> findAll() {
        return clothingRepository.findAll();
    }

    public Optional<Clothing> findById(Long id) {
        return clothingRepository.findById(id);
    }

    public Clothing save(Clothing clothing) {
        return clothingRepository.save(clothing);
    }

    public void deleteById(Long id) {
        clothingRepository.deleteById(id);
    }
}
