package com.company.service;

import com.company.dto.BookDTO;
import com.company.model.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        Book bookFromDb = bookRepository.getOne(book.getId());
        if(bookFromDb != null){
            return bookRepository.save(book);
        }else {
            throw new RuntimeException("Book with id: " + book.getId()
                    + "does not exists!");
        }
    }

    public List<Book> filterBook(Book book) {
        Example<Book> bookExample = Example.of(book);
        return bookRepository.findAll(bookExample);
    }
}
