package com.example.artshop.controller;

import com.example.artshop.model.User;
import com.example.artshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // возвращаем имя представления страницы входа
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // возвращаем имя представления страницы регистрации
    }

    @PostMapping("/register")
    public String addUser(User user, @RequestParam String passwordConfirm) {
        if (!user.getPassword().equals(passwordConfirm)) {
            return "register";
        }

        if (!userService.register(user)) {
            return "register";
        }

        return "redirect:/login";
    }
}