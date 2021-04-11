package com.company.service;

import com.company.model.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAllBooksByYear(String year) {
        return bookRepository.findByYear(year);
    }

    public List<Book> getAllBooksByInAnnotation(String keyword) {
        return bookRepository.findByAnnotationLike("%" + keyword + "%");
    }

}
