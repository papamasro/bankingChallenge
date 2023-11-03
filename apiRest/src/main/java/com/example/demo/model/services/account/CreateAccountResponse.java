package com.example.demo.model.services.account;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CreateAccountResponse {
    @JsonProperty("accountNumber")
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private BigDecimal balance;

    public CreateAccountResponse(Long id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public CreateAccountResponse() {
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
