package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Client;
import com.example.demo.service.CommandeService;

import jakarta.servlet.http.HttpSession;

public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @PostMapping("/home")
    public String createCommande(@RequestParam String titre, HttpSession session) {
        Client client = (Client) session.getAttribute("user");
        if (client != null) {
            commandeService.createCommande(titre, client);
            return "redirect:/home";
        }
        return "redirect:/login";
    }

}
