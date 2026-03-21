package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.entity.Product;
import com.inventory.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Add sample product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // Get all products
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // 🔹 Derived Query - Category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // 🔹 Derived Query - Price Range
    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam double min,
                                       @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // 🔹 JPQL - Sorted
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.findAllSortedByPrice();
    }

    // 🔹 JPQL - Expensive
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }

    // 🔹 JPQL - Category
    @GetMapping("/jpql/{category}")
    public List<Product> categoryJPQL(@PathVariable String category) {
        return repo.findProductsByCategoryJPQL(category);
    }
}