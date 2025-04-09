package com.example.SampleJPAREST.controller;

import com.example.SampleJPAREST.entities.Samples;
import com.example.SampleJPAREST.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class SampleController {

    @Autowired
    private SampleService bookService;


    @GetMapping("/books")
    public List<Samples> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Samples> getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public Samples addBook(@Valid @RequestBody Samples book) {
        Samples b = this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{bookid}")
    public String deleteBook(@PathVariable("bookid") int bookid) {
        this.bookService.deleteBook(bookid);
        return "data deleted successfully";
    }

    @DeleteMapping()
    public void deleteAll() {
        bookService.deleteAllBooks();
    }

    @PutMapping("/books/{bookid}")
    public Samples updateBook(@Valid @RequestBody Samples book, @PathVariable("bookid") int bookid) {
        this.bookService.updatebook(book, bookid);
        return book;
    }

//        @GetMapping("/Books/query/{author}")
//        public boolean query(@PathVariable("author") String name) throws JsonProcessingException {
//          return bookService.getBookByName(name);
//
//        }

}
