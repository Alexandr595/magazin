package com.example.artshop.controller;

import com.example.artshop.service.EmailService;
import com.example.artshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordResetController {

    private final UserService userService;
    private final EmailService emailService;

    public PasswordResetController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";  // имя представления страницы забытого пароля
    }

    @PostMapping("/forgot-password")
    public String processForgotPasswordForm(@RequestParam String email) {
        // генерируем временный пароль
        String temporaryPassword = userService.generateTemporaryPassword();

        // обновляем пароль пользователя
        userService.updatePassword(email, temporaryPassword);

        // отправляем временный пароль на электронную почту пользователя
        emailService.sendSimpleMessage(email, "Your temporary password", "Your temporary password is: " + temporaryPassword);

        return "redirect:/login";
    }
}