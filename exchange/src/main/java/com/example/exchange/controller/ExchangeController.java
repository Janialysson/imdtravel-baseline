package com.example.exchange.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ExchangeController {

    @GetMapping("/exchange")
    public double getExchange() {
        double rate = 5.0 + Math.random(); // between 5 and 6
        rate = Math.round(rate * 100.0) / 100.0;
        return rate;
    }
}
