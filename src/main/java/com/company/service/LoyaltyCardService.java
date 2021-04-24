package com.company.service;

import com.company.constants.LoyaltyCardType;
import com.company.model.LoyaltyCard;
import com.company.model.User;
import com.company.repository.LoyaltyCardRepository;
import com.company.repository.UserRepository;
import com.company.service.validator.LoyaltyCardValidator;
import com.company.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoyaltyCardService {

    private final LoyaltyCardRepository loyaltyCardRepository;
    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final LoyaltyCardValidator loyaltyCardValidator;

    @Autowired
    public LoyaltyCardService(LoyaltyCardRepository loyaltyCardRepository, UserRepository userRepository, UserValidator userValidator, LoyaltyCardValidator loyaltyCardValidator) {
        this.loyaltyCardRepository = loyaltyCardRepository;
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.loyaltyCardValidator = loyaltyCardValidator;
    }

    public LoyaltyCard saveLoyaltyCard(LoyaltyCard loyaltyCard){
        return loyaltyCardRepository.save(loyaltyCard);
    }

    public List<LoyaltyCard> findAll(){
        return loyaltyCardRepository.findAll();
    }

    public void assignLoyaltyCardToUser(Long userId, Long loyaltyCardId){
        User user = userValidator.checkUserExists(userId);
        LoyaltyCard loyaltyCard = loyaltyCardValidator
                .checkLoyaltyCardExists(loyaltyCardId);

        user.setLoyaltyCard(loyaltyCard);
        userRepository.save(user);

        loyaltyCard.setUser(user);
        loyaltyCardRepository.save(loyaltyCard);
    }

    public void removeLoyaltyCardFromUser(Long userId,
                                          Long loyaltyCardId){

        User user = userValidator.checkUserExists(userId);
        LoyaltyCard loyaltyCard = loyaltyCardValidator
                .checkLoyaltyCardExists(loyaltyCardId);

        userValidator.checkUserHaveLoyaltyCard(user, loyaltyCardId);

        user.setLoyaltyCard(null);
        userRepository.save(user);

        loyaltyCard.setUser(null);
        loyaltyCardRepository.save(loyaltyCard);
    }

    public void assignNewTypeToLoyaltyCard(Long loyaltyCardId,
                                           LoyaltyCardType loyaltyCardType){

        LoyaltyCard loyaltyCard = loyaltyCardValidator
                .checkLoyaltyCardExists(loyaltyCardId);

        loyaltyCard.setType(loyaltyCardType);
        loyaltyCardRepository.save(loyaltyCard);
    }



}
