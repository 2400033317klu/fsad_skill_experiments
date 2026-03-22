package com.inventory.controller;

import org.springframework.web.bind.annotation.*;

import com.inventory.dto.Student;
import com.inventory.exception.InvalidInputException;
import com.inventory.exception.StudentNotFoundException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id){

        int studentId;

        try{
            studentId = Integer.parseInt(id);
        }
        catch(NumberFormatException e){
            throw new InvalidInputException("Student ID must be a number");
        }

        if(studentId <= 0){
            throw new InvalidInputException("Student ID must be positive");
        }

        if(studentId != 101){
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }

        return new Student(101, "Bhavi", "CSE");
    }
}