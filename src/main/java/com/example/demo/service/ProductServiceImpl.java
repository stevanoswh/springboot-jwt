package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products =  repository.findAll(); // SELECT * FROM products
        System.out.println(products.toString());
        return products;
    }

    @Override
    public Product getProductById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product not found with id: " + id )); // SELECT + WHERE
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println(product.getCategories());
        return repository.save(product); // INSERT INTO
    }

    @Override
    public Product updateProduct(UUID id, Product product) {
        Product existProduct = getProductById(id);
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        existProduct.setDescription(product.getDescription());
        return repository.save(existProduct); // SET WHERE
    }

    @Override
    public void deleteProduct(UUID id) {
        getProductById(id);
        repository.deleteById(id); // DELETE by id
    }

}

