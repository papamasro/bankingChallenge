package com.example.demo.model.services.transaction;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransactionResponse {
    @JsonProperty("transactionId")
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String date;

    @JsonProperty
    private BigDecimal balance;

    public TransactionResponse(Long id, String name, String date, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.balance = balance;
    }

    public TransactionResponse() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
