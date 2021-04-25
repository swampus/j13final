package com.company.repository;

import com.company.model.LoyaltyCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyCardRepository
        extends JpaRepository<LoyaltyCard, Long> {
    LoyaltyCard findByNumLike(String num);

    LoyaltyCard findByUserId(Long id);
}
