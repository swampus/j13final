package com.company.repository;

import com.company.model.Book;
import com.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPersonalCode(String personalCode);
    List<User> findByFavoriteBookLike(String favoriteBook);
}

