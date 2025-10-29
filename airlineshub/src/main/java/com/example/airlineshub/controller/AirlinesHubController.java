package com.example.airlineshub.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class AirlinesController {

    @GetMapping("/flight")
    public Map<String, Object> getFlight(@RequestParam String flight, @RequestParam String day) throws InterruptedException {
        // quick simulation: value in USD
        Map<String, Object> resp = new HashMap<>();
        resp.put("flight", flight);
        resp.put("day", day);
        resp.put("value", 200.0);
        return resp;
    }

    @PostMapping("/sell")
    public Map<String, Object> sellTicket(@RequestParam String flight, @RequestParam String day) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("transactionId", UUID.randomUUID().toString());
        return resp;
    }
}
