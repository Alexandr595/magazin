package com.example.artshop.service;

import com.example.artshop.model.Painting;
import com.example.artshop.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaintingService {

    private final PaintingRepository paintingRepository;

    @Autowired
    public PaintingService(PaintingRepository paintingRepository) {
        this.paintingRepository = paintingRepository;
    }

    public List<Painting> findAll() {
        return paintingRepository.findAll();
    }

    public Optional<Painting> findById(Long id) {
        return paintingRepository.findById(id);
    }

    public Painting save(Painting painting) {
        return paintingRepository.save(painting);
    }

    public void deleteById(Long id) {
        paintingRepository.deleteById(id);
    }
}
// В этом классе используется аннотация @Service, которая указывает на то,
// что этот класс является сервисным компонентом Spring.
// Внедряем зависимость PaintingRepository через конструктор с аннотацией @Autowired.
// Методы findAll, findById, save и deleteById выполняют основные операции над сущностями Painting с
// использованием методов из PaintingRepository.
