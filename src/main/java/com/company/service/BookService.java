package com.company.service;

import com.company.model.Book;
import com.company.model.User;
import com.company.repository.BookRepository;
import com.company.service.validator.BookValidator;
import com.company.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookService {

    private final BookRepository bookRepository;
    private final BookValidator bookValidator;
    private final UserValidator userValidator;

    @Autowired
    public BookService(BookRepository bookRepository, BookValidator bookValidator, UserValidator userValidator) {
        this.bookRepository = bookRepository;
        this.bookValidator = bookValidator;
        this.userValidator = userValidator;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAllByStatus("ACTIVE");
    }

    public void deleteBook(Long bookId){
        Book book = bookValidator.checkBookExists(bookId);
        book.setStatus("DELETED");
        bookRepository.save(book);
    }

    public List<Book> getAllBooksByYear(String year) {
        return bookRepository.findByYearAndStatus(year, "ACTIVE");
    }

    public List<Book> getAllBooksByInAnnotation(String keyword) {
        return bookRepository.findByAnnotationLikeAndStatus("%" + keyword + "%", "ACTIVE");
    }

    public Book saveBook(Book book) {
        book.setStatus("ACTIVE");
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        bookValidator.checkBookExists(book.getId());
        return bookRepository.save(book);
    }

    public List<Book> filterBook(Book book) {
        book.setStatus("ACTIVE");
        Example<Book> bookExample = Example.of(book);
        return bookRepository.findAll(bookExample);
    }

    public void addBookToUser(Long userId, Long bookId) {
        Book book = bookValidator.checkBookExists(bookId);
        User user = userValidator.checkUserExists(userId);
        userValidator.checkUserDoesNotHaveMoreThenFiveBook(user);
        book.setUser(user);
        bookRepository.save(book);
    }

    public void removeBookFromUser(Long userId, Long bookId) {
        Book book = bookValidator.checkBookExists(bookId);
        User user = userValidator.checkUserExists(userId);
        userValidator.checkUserHaveBook(user, bookId);
        book.setUser(null);
        bookRepository.save(book);
    }

}
