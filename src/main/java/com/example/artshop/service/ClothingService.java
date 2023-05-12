package com.example.artshop.service;

import com.example.artshop.model.Clothing;
import com.example.artshop.repository.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingService {

    @Autowired
    private ClothingRepository clothingRepository;

    public List<Clothing> getAllClothing() {
        return clothingRepository.findAll();
    }

    public Clothing addClothing(Clothing clothing) {
        return clothingRepository.save(clothing);
    }
}
