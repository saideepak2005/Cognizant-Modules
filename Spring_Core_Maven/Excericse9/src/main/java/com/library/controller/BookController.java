package com.library.controller;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}