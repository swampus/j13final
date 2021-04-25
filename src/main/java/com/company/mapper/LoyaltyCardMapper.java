package com.company.mapper;

import com.company.dto.LoyaltyCardDTO;
import com.company.model.LoyaltyCard;
import org.springframework.stereotype.Component;

@Component
public class LoyaltyCardMapper {

    public LoyaltyCard fromDTO(LoyaltyCardDTO loyaltyCardDTO) {
        LoyaltyCard loyaltyCard = new LoyaltyCard();
        loyaltyCard.setId(loyaltyCardDTO.getId());
        loyaltyCard.setNum(loyaltyCardDTO.getNum());
        loyaltyCard.setType(loyaltyCardDTO.getType());
        return loyaltyCard;
    }

    public LoyaltyCardDTO toDTO(LoyaltyCard loyaltyCard) {
        LoyaltyCardDTO loyaltyCardDTO = new LoyaltyCardDTO();
        loyaltyCardDTO.setId(loyaltyCard.getId());
        loyaltyCardDTO.setNum(loyaltyCard.getNum());
        loyaltyCardDTO.setType(loyaltyCard.getType());
        return loyaltyCardDTO;
    }
}
