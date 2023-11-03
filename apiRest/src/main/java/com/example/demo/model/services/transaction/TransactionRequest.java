package com.example.demo.model.services.transaction;

import java.math.BigDecimal;


public class TransactionRequest {

    private Long accountNumber;

    private String transactionType;

    private BigDecimal amount;

    public TransactionRequest(Long accountNumber, String transactionType, BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public TransactionRequest() {
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
