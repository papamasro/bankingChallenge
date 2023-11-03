package com.example.demo.service;

import com.example.demo.model.services.account.CreateAccountRequest;
import com.example.demo.model.services.account.CreateAccountResponse;
import com.example.demo.model.services.account.GetBalanceResponse;

public interface Account {

    GetBalanceResponse getAccountBalance(Long id);

    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);
}
