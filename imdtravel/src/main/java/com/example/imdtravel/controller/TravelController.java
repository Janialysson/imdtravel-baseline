package com.example.imdtravel.controller;

import com.example.imdtravel.service.TravelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @PostMapping("/buyTicket")
    public ResponseEntity<String> buyTicket(@RequestParam String flight, @RequestParam String day, @RequestParam int user) {
        String r = travelService.buyTicket(flight, day, user);
        if (r.startsWith("SUCCESS")) {
            return ResponseEntity.ok(r);
        } else {
            return ResponseEntity.status(500).body(r);
        }
    }
}
