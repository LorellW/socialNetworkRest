package com.github.lorellw.socialNetworkRest.controllers;

import com.github.lorellw.socialNetworkRest.entities.User;
import com.github.lorellw.socialNetworkRest.repositories.MessageRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    private final MessageRepository repository;

    public MainController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile", user);
        data.put("messages", repository.findAll());

        model.addAttribute("frontendData", data);
        return "index";
    }
}
