package com.inventory.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 101;
    private String name = "Bhavi";
    private String gender = "Female";

    @Autowired
    private Certification certification;   // 🔥 AUTO INJECTION

    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);

        System.out.println("---- Certification Details ----");
        certification.display();
    }
}