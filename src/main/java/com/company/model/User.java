package com.company.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "personal_code")
    private String personalCode;
    @Column(name = "address")
    private String address;
    @Column(name = "favorite_book")
    private String favoriteBook;
    @OneToMany(mappedBy = "user")
    private Set<Book> books;
    @OneToOne(mappedBy = "user")
    private LoyalityCard loyaltyCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(String favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public LoyalityCard getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(LoyalityCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
}
