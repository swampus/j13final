package com.company.repository;

import com.company.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByYearAndStatus(String year, String status);

    List<Book> findByAnnotationLikeAndStatus(String keyword, String status);

    List<Book> findAllByStatus(String status);

    Book findByIdAndStatus(Long id, String status);
}
