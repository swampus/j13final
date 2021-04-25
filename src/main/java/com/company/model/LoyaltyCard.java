package com.company.model;

import com.company.constants.LoyaltyCardType;

import javax.persistence.*;

@Entity
@Table(name = "loyalty_card")
public class LoyaltyCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "num")
    private String num;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private LoyaltyCardType type;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
