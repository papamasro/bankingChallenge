package com.example.demo.model.services.transaction;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public class TransactionRequest {
    @Valid
    @NotNull(message = "Account Number must not be null")
    @DecimalMin("0.0")
    private Long accountNumber;
    @Valid
    @NotNull(message = "Transaction Type must not be null")
    private String transactionType;
    @Valid
    @NotNull(message = "Amount must not be null")
    @DecimalMin("0.0")
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
