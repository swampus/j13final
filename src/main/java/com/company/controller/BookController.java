package com.company.controller;

import com.company.dto.BookDTO;
import com.company.mapper.BookMapper;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rest/Book.svc")
public class BookController {

    private final BookMapper bookMapper;
    private final BookService bookService;

    @Autowired
    public BookController(BookMapper bookMapper,
                          BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDTO> findAllBooks() {
        return bookService.getAllBooks().stream()
                //.map(t->bookMapper.toDto(t))
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());

    }

    @DeleteMapping("/book({id})")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }


    @GetMapping("/Book/year/{year}")
    public List<BookDTO> findAllBooks(@PathVariable("year")
                                              String year) {
        return bookService.getAllBooksByYear(year)
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/Book/annotation/{keyword}")
    public List<BookDTO> findAllBooksByInAnnotation(@PathVariable("keyword")
                                                            String keyword) {
        return bookService.getAllBooksByInAnnotation(keyword)
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/Book")
    public BookDTO createBook(@RequestBody BookDTO book) {
        return bookMapper.toDTO(
                bookService.saveBook(bookMapper.fromDTO(book)));
    }

    @PutMapping("/Book")
    public void updateBook(@RequestBody BookDTO book) {
        bookService.updateBook(bookMapper.fromDTO(book));
    }

    @PostMapping("/book/filter")
    public List<BookDTO> filterBooks(@RequestBody BookDTO bookDTO) {
        return bookService.filterBook(bookMapper.fromDTO(bookDTO))
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/user/add")
    public void addBookToUser(@RequestParam Long userId,
                              @RequestParam Long bookId) {
        bookService.addBookToUser(userId, bookId);
    }

    @PutMapping("/user/remove")
    public void removeBookFromUser(@RequestParam Long userId,
                                   @RequestParam Long bookId) {
        bookService.removeBookFromUser(userId, bookId);
    }


}
