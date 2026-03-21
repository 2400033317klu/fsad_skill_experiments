package com.inventory.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 1;
    private String name = "Java Full Stack";
    private String dateOfCompletion = "2026";

    public void display() {
        System.out.println("Certification ID: " + id);
        System.out.println("Certification Name: " + name);
        System.out.println("Completion Date: " + dateOfCompletion);
    }
}