package com.inventory.runner;

import com.inventory.entity.Product;
import com.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository repo;

    @Override
    public void run(String... args) {

        // Insert data
        repo.save(new Product("Laptop", "Electronics", 70000, 10));
        repo.save(new Product("Mouse", "Electronics", 1200, 50));
        repo.save(new Product("Keyboard", "Electronics", 2500, 30));
        repo.save(new Product("Chair", "Furniture", 5000, 5));
        repo.save(new Product("Table", "Furniture", 8000, 2));
        repo.save(new Product("Pen", "Stationary", 20, 100));

        System.out.println("===== SORTING =====");

        System.out.println("Price Asc:");
        repo.findAllByOrderByPriceAsc().forEach(p -> System.out.println(p.getName()));

        System.out.println("Price Desc:");
        repo.findAllByOrderByPriceDesc().forEach(p -> System.out.println(p.getName()));

        System.out.println("Quantity Desc:");
        repo.findAllByOrderByQuantityDesc().forEach(p -> System.out.println(p.getName()));

        System.out.println("===== AGGREGATES =====");

        System.out.println("Total Products: " + repo.countAllProducts());
        System.out.println("Available Products: " + repo.countAvailableProducts());

        System.out.println("Min & Max Price:");
        Object[] minMax = repo.findMinMaxPrice();

        if (minMax != null && minMax.length >= 2) {
            System.out.println("Min: " + minMax[0] + " Max: " + minMax[1]);
        } else {
            System.out.println("Min/Max data not available");
        }

        System.out.println("===== WHERE =====");

        repo.findByPriceRange(1000, 10000)
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("===== LIKE =====");

        repo.startsWith("L").forEach(p -> System.out.println(p.getName()));
        repo.endsWith("r").forEach(p -> System.out.println(p.getName()));
        repo.containsText("a").forEach(p -> System.out.println(p.getName()));
    }
}