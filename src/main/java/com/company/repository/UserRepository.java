package com.company.repository;

import com.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPersonalCode(String personalCode);

    List<User> findByFavoriteBookLike(String favoriteBook);

    List<User> findDistinctByBooksNameLike(String bookName);

    /**
     //HSQL example
     @Query("Select User from User u WHERE favoriteBook like = ?")
     User asfasfasfasafasf(String abc, long ttt);
     **/
}

