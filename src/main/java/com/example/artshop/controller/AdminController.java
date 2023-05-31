package com.example.artshop.controller;

import com.example.artshop.model.Painting;
import com.example.artshop.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PaintingService paintingService;

    @Autowired
    public AdminController(PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    @GetMapping("/paintings")
    public String getAllPaintings(Model model) {
        model.addAttribute("paintings", paintingService.findAll());
        return "admin/paintings";
    }

    @GetMapping("/paintings/new")
    public String createPaintingForm(Model model) {
        model.addAttribute("painting", new Painting());
        return "admin/paintings/new";
    }

    @PostMapping("/paintings")
    public String createPainting(Painting painting) {
        paintingService.save(painting);
        return "redirect:/admin/paintings";
    }

    @GetMapping("/paintings/edit/{id}")
    public String editPaintingForm(@PathVariable Long id, Model model) {
        Painting painting = paintingService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid painting Id:" + id));
        model.addAttribute("painting", painting);
        return "admin/paintings/edit";
    }

    @PostMapping("/paintings/{id}")
    public String updatePainting(Painting painting, @PathVariable Long id) {
        // Добавьте проверки и обработку ошибок здесь
        paintingService.save(painting);
        return "redirect:/admin/paintings";
    }

    @GetMapping("/paintings/delete/{id}")
    public String deletePainting(@PathVariable Long id) {
        paintingService.deleteById(id);
        return "redirect:/admin/paintings";
    }

    // Метод выхода
    @PostMapping("/logout")
    public String logout() {
        // Spring Security обычно обрабатывает это автоматически,
        // вы можете включить перенаправление или дополнительную логику здесь, если это необходимо
        return "redirect:/";
    }
}