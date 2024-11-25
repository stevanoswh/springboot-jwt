package com.example.demo.dto;

import java.util.Set;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    
    private String description;
    
    private Double price;
    
    private Integer quantity;
    
    private CountryRef madeIn;
    
    private Set<CategoryRef> categories;
}