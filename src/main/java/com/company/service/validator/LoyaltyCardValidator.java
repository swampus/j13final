package com.company.service.validator;

import com.company.exception.EntityDoesNotExistsException;
import com.company.model.LoyaltyCard;
import com.company.model.User;
import com.company.repository.LoyaltyCardRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoyaltyCardValidator {

    private final LoyaltyCardRepository loyaltyCardRepository;


    public LoyaltyCardValidator(LoyaltyCardRepository loyaltyCardRepository) {
        this.loyaltyCardRepository = loyaltyCardRepository;
    }

    public LoyaltyCard checkLoyaltyCardExists(Long loyaltyCardId) {
        Optional<LoyaltyCard> loyaltyCardOpt = loyaltyCardRepository.findById(loyaltyCardId);
        return loyaltyCardOpt.orElseThrow(() ->
                new EntityDoesNotExistsException("LoyaltyCard: (" + loyaltyCardId
                        + ") not exists!"));
    }


}
