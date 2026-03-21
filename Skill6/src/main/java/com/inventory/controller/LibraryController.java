package com.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.inventory.model.Book;

@RestController
public class LibraryController {

    // In-memory list
    private List<Book> bookList = new ArrayList<>();

    // 1. Welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 2. Count
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // 3. Price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // 4. Get all books (titles)
    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> titles = new ArrayList<>();
        titles.add("Java");
        titles.add("Spring");
        titles.add("Hibernate");
        return titles;
    }

    // 5. Book by ID
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    // 6. Search by title
    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 7. Author name
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // 8. Add book (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    // 9. View all books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}