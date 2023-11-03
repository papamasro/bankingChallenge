package com.example.demo.controller;

import com.example.demo.model.services.account.CreateAccountRequest;
import com.example.demo.model.services.account.CreateAccountResponse;
import com.example.demo.model.services.account.GetBalanceResponse;
import com.example.demo.service.impl.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/")
@Validated
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("accounts")
    @ResponseBody
    public ResponseEntity<CreateAccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest) {
        CreateAccountResponse createAccountResponse = accountService.createAccount(createAccountRequest);
        return ResponseEntity.ok(createAccountResponse);
    }

    @GetMapping("accounts/{id}/balance")
    @ResponseBody
    public ResponseEntity<GetBalanceResponse> getBalance(@Valid @PathVariable Long id) {
        GetBalanceResponse getBalanceResponse = accountService.getAccountBalance(id);
        return ResponseEntity.ok(getBalanceResponse);
    }

}
