package com.example.demo.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Country;

public interface CountryRepository extends JpaRepository<Country, UUID> {

}