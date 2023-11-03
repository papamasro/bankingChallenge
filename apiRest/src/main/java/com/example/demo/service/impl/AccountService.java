package com.example.demo.service.impl;

import com.example.demo.exception.UsernameNotFoundException;
import com.example.demo.model.entity.Accounts;
import com.example.demo.model.services.account.CreateAccountRequest;
import com.example.demo.model.services.account.CreateAccountResponse;
import com.example.demo.model.services.account.GetBalanceResponse;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.Account;
import com.example.demo.util.DateFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService implements Account {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public GetBalanceResponse getAccountBalance(Long id) {
        logger.info("calling get account service");
        Optional<Accounts> account = accountRepository.findById(id);
        if (account.isPresent()) {
            logger.info("get account service success with account id: " + id);
            return new GetBalanceResponse(account.get().getId(), account.get().getName(), account.get().getBalance());
        } else
            throw new UsernameNotFoundException("User not found to get balance");
    }

    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        logger.info("calling create account service");
        Accounts newAccount = new Accounts(createAccountRequest.getName(), BigDecimal.valueOf(0.0), DateFormatter.getStringDate());
        newAccount = accountRepository.save(newAccount);
        logger.info("account created success with account id: " + newAccount.getId());
        return new CreateAccountResponse(newAccount.getId(), newAccount.getName(), BigDecimal.valueOf(0.0));
    }
}
