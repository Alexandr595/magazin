package com.example.artshop.controller;

import com.example.artshop.model.Painting;
import com.example.artshop.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paintings")
public class PaintingController {

    private final PaintingService paintingService;

    @Autowired
    public PaintingController(PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    @GetMapping
    public ResponseEntity<List<Painting>> getAllPaintings() {
        return ResponseEntity.ok(paintingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Painting> getPaintingById(@PathVariable Long id) {
        return paintingService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Painting> createPainting(@RequestBody Painting painting) {
        return new ResponseEntity<>(paintingService.save(painting), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Painting> updatePainting(@PathVariable Long id, @RequestBody Painting painting) {
        return paintingService.findById(id)
                .map(existingPainting -> {
                    painting.setId(existingPainting.getId());
                    return ResponseEntity.ok(paintingService.save(painting));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePainting(@PathVariable Long id) {
        return paintingService.findById(id)
                .map(painting -> {
                    paintingService.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElse(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
}
// В этом классе используются аннотации @RestController и @RequestMapping, которые указывают на то,
// что этот класс является контроллером Spring, обрабатывающим HTTP-запросы по адресу /api/paintings.
// Внедряем зависимость PaintingService через конструктор с аннотацией @Autowired. Методы getAllPaintings,
// getPaintingById, createPainting, updatePainting и deletePainting обрабатывают соответствующие HTTP-запросы
// и возвращают результаты с использованием методов PaintingService.