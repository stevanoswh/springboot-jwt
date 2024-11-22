package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;

@Service
public class CountryServiceImpl {
    private final CountryRepository repo;

    public CountryServiceImpl(CountryRepository repo) {
        this.repo = repo;
    }

    public Country create(Country req) {
        return repo.save(req);
    }

    public List<Country> getAll() {
        return repo.findAll();
    }
}
