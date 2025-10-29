package com.example.fidelity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FidelityController {

    @PostMapping("/bonus")
    public ResponseEntity<String> addBonus(@RequestParam int user, @RequestParam int bonus) {
        System.out.println("Bônus de " + bonus + " para usuário " + user);
        return ResponseEntity.ok("Bônus registrado");
    }
}
