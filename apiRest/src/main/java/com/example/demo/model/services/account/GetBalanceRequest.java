package com.example.demo.model.services.account;

public class GetBalanceRequest {
    private Long id;
    private String name;

    private double balance;

    public GetBalanceRequest(Long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public GetBalanceRequest() {
    }
}
