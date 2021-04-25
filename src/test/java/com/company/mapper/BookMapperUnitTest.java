package com.company.mapper;

import com.company.dto.BookDTO;
import com.company.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
public class BookMapperUnitTest {

    private BookMapper bookMapper = new BookMapper();

    @Test
    public void fromDTO() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAnnotation("A1");
        bookDTO.setAuthor("Author");
        bookDTO.setId(1L);
        bookDTO.setISBN("ISBV-11");
        bookDTO.setName("Name");
        bookDTO.setYear("2200");

        Book book = bookMapper.fromDTO(bookDTO);
        assertEquals("A1", book.getAnnotation());
        assertEquals("Author", book.getAuthor());
        assertEquals(1L, book.getId());
        assertEquals("ISBV-11", book.getISBN());
        assertEquals("Name", book.getName());
        assertEquals("2200", book.getYear());
    }

    @Test
    public void toDTO() {
        Book book = new Book();
        book.setAnnotation("A1");
        book.setAuthor("Author");
        book.setId(1L);
        book.setISBN("ISBV-11");
        book.setName("Name");
        book.setYear("2200");

        BookDTO bookDTO = bookMapper.toDTO(book);
        assertEquals("A1", bookDTO.getAnnotation());
        assertEquals("Author", bookDTO.getAuthor());
        assertEquals(1L, bookDTO.getId());
        assertEquals("ISBV-11", bookDTO.getISBN());
        assertEquals("Name", bookDTO.getName());
        assertEquals("2200", bookDTO.getYear());
    }
}