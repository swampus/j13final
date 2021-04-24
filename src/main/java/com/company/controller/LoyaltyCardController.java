package com.company.controller;

import com.company.dto.LoyaltyCardDTO;
import com.company.dto.UserDTO;
import com.company.mapper.LoyaltyCardMapper;
import com.company.mapper.UserMapper;
import com.company.model.LoyaltyCard;
import com.company.model.User;
import com.company.service.LoyaltyCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rest/LoyaltyCard.svc")
public class LoyaltyCardController {

    private final LoyaltyCardService loyaltyCardService;
    private final LoyaltyCardMapper loyaltyCardMapper;
    private final UserMapper userMapper;

    public LoyaltyCardController(LoyaltyCardService loyaltyCardService,
                                 LoyaltyCardMapper loyaltyCardMapper, UserMapper userMapper) {
        this.loyaltyCardService = loyaltyCardService;
        this.loyaltyCardMapper = loyaltyCardMapper;
        this.userMapper = userMapper;
    }

    @PostMapping("/loyaltyCard")
    public LoyaltyCardDTO saveLoyaltyCard(@RequestBody LoyaltyCardDTO loyaltyCardDTO) {
        return loyaltyCardMapper.toDTO(
                loyaltyCardService.saveLoyaltyCard(
                        loyaltyCardMapper.fromDTO(loyaltyCardDTO)));
    }

    @GetMapping("/loyaltyCards")
    public List<LoyaltyCardDTO> getAllLoyaltyCards() {
        List<LoyaltyCard> loyaltyCards = loyaltyCardService.findAll();
        return loyaltyCards.stream().map(t -> {
            LoyaltyCardDTO loyaltyCardDTO = loyaltyCardMapper.toDTO(t);
            User ownerLoyaltyCard = t.getUser();
            if (ownerLoyaltyCard != null) {
                UserDTO userDTO = userMapper.toDTO(ownerLoyaltyCard);
                loyaltyCardDTO.setUser(userDTO);
            }
            return loyaltyCardDTO;
        }).collect(Collectors.toList());
    }

    @PutMapping("/user({userId})/loyaltyCard({cardId})/assign")
    public void assignLoyaltyCardToUser(@PathVariable("userId") Long userId,
                                        @PathVariable("cardId") Long cardId) {
        loyaltyCardService.assignLoyaltyCardToUser(userId, cardId);
    }

    @PutMapping("/user({userId})/loyaltyCard({cardId})/remove")
    public void removeLoyaltyCardFromUser(@PathVariable("userId") Long userId,
                                          @PathVariable("cardId") Long cardId) {
        loyaltyCardService.removeLoyaltyCardFromUser(userId, cardId);
    }


}
