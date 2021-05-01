package com.company.service.validator;

import com.company.exception.EntityDoesNotExistsException;
import com.company.model.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookValidator {

    private final BookRepository bookRepository;

    @Autowired
    public BookValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book checkBookExists(Long bookId) {
        Optional<Book> bookFromDBOpt = Optional.ofNullable(bookRepository.findByIdAndStatus(bookId, "ACTIVE"));
        return bookFromDBOpt.orElseThrow(() ->
                new EntityDoesNotExistsException("Book: (" + bookId
                        + ") not exists!"));
    }
}
