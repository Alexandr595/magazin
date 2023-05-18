package com.example.artshop.controller;

import com.example.artshop.model.Clothing;
import com.example.artshop.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothing")
public class ClothingController {

    private final ClothingService clothingService;

    @Autowired
    public ClothingController(ClothingService clothingService) {
        this.clothingService = clothingService;
    }

    @GetMapping
    public List<Clothing> getAllClothing() {
        return clothingService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clothing> getClothingById(@PathVariable Long id) {
        return clothingService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Clothing addClothing(@RequestBody Clothing clothing) {
        return clothingService.save(clothing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothing(@PathVariable Long id) {
        clothingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}