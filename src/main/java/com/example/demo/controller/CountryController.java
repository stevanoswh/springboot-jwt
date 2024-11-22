package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Country;
import com.example.demo.service.CountryServiceImpl;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryServiceImpl service;

    public CountryController(CountryServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country req) {
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
