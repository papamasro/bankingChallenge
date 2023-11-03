package com.example.demo.model.services.account;

import java.math.BigDecimal;


public class CreateAccountRequest {
    private Long id;
    private String name;
    private BigDecimal balance;

    public CreateAccountRequest(Long id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public CreateAccountRequest() {
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
