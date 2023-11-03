package com.example.demo.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "account")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal balance;
    private String created;

    public Accounts(String name, BigDecimal balance, String created) {
        this.name = name;
        this.balance = balance;
        this.created = created;
    }

    public Accounts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
