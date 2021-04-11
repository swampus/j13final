package com.company.controller;

import com.company.model.Book;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rest/Book.svc")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/Book/year/{year}")
    public List<Book> findAllBooks(@PathVariable("year")
                                               String year) {
        return bookService.getAllBooksByYear(year);
    }

    @GetMapping("/Book/annotation/{keyword}")
    public List<Book> findAllBooksByInAnnotation(@PathVariable("keyword")
                                           String keyword) {
        return bookService.getAllBooksByInAnnotation(keyword);
    }
}
