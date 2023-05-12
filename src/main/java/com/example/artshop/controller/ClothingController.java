package com.example.artshop.controller;

import com.example.artshop.model.Clothing;
import com.example.artshop.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clothing")
public class ClothingController {

    @Autowired
    private ClothingService clothingService;

    @GetMapping
    public List<Clothing> getAllClothing() {
        return clothingService.getAllClothing();
    }

    @PostMapping
    public Clothing addClothing(@RequestBody Clothing clothing) {
        return clothingService.addClothing(clothing);
    }
}