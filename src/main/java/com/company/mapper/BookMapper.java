package com.company.mapper;

import com.company.dto.BookDTO;
import com.company.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book fromDTO(BookDTO bookDTO) {
        Book book = new Book();
        book.setAnnotation(bookDTO.getAnnotation());
        book.setAuthor(bookDTO.getAuthor());
        book.setId(bookDTO.getId());
        book.setISBN(bookDTO.getISBN());
        book.setName(bookDTO.getName());
        book.setYear(bookDTO.getYear());
        return book;
    }

    public BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAnnotation(book.getAnnotation());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setId(book.getId());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setName(book.getName());
        bookDTO.setYear(book.getYear());
        return bookDTO;
    }
}
