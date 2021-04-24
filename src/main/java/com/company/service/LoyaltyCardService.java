package com.company.service;

import com.company.model.LoyaltyCard;
import com.company.model.User;
import com.company.repository.LoyaltyCardRepository;
import com.company.repository.UserRepository;
import com.company.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoyaltyCardService {

    private final LoyaltyCardRepository loyaltyCardRepository;
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    @Autowired
    public LoyaltyCardService(LoyaltyCardRepository loyaltyCardRepository, UserRepository userRepository, UserValidator userValidator) {
        this.loyaltyCardRepository = loyaltyCardRepository;
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public LoyaltyCard saveLoyaltyCard(LoyaltyCard loyaltyCard){
        return loyaltyCardRepository.save(loyaltyCard);
    }

    public List<LoyaltyCard> findAll(){
        return loyaltyCardRepository.findAll();
    }

    public void assignLoyaltyCardToUser(Long userId, Long loyaltyCardId){
        User user = userValidator.checkUserExists(userId);
    }

    public void removeLoyaltyCardFromUser(Long userId, Long loyaltyCardId){

    }



}
