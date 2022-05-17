package com.example.pp_3_1_4_rest.controller;

import com.example.pp_3_1_4_rest.model.User;
import com.example.pp_3_1_4_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService service;

    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Principal principal,
                        Model model) {
        User user = service.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "/admin";
    }
}