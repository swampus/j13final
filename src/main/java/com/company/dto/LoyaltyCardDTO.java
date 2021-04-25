package com.company.dto;

import com.company.constants.LoyaltyCardType;

public class LoyaltyCardDTO {

    private Long id;
    private String num;
    private LoyaltyCardType type;
    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public LoyaltyCardType getType() {
        return type;
    }

    public void setType(LoyaltyCardType type) {
        this.type = type;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
