package com.example.demo.service;

import com.example.demo.exception.UsernameNotFoundException;
import com.example.demo.model.entity.Accounts;
import com.example.demo.model.services.account.CreateAccountRequest;
import com.example.demo.model.services.account.CreateAccountResponse;
import com.example.demo.model.services.account.GetBalanceResponse;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.impl.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAccountBalance() {
        // Arrange
        Long accountId = 1L;
        Accounts account = new Accounts();
        account.setId(accountId);
        account.setName("John Doe");
        account.setBalance(BigDecimal.valueOf(1000.0));

        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));

        // Act
        GetBalanceResponse response = accountService.getAccountBalance(accountId);

        // Assert
        assertEquals(accountId, response.getId());
        assertEquals("John Doe", response.getName());
        assertEquals(BigDecimal.valueOf(1000.0), response.getBalance());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testGetAccountBalanceAccountNotFound() {
        // Arrange
        Long accountId = 2L;

        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // Act
        accountService.getAccountBalance(accountId);
    }

    @Test
    public void testCreateAccount() {
        // Arrange
        CreateAccountRequest request = new CreateAccountRequest();
        request.setName("Jane Smith");

        Accounts newAccount = new Accounts();
        newAccount.setId(1L);
        newAccount.setName("Jane Smith");
        newAccount.setBalance(BigDecimal.valueOf(0.0));

        when(accountRepository.save(any())).thenReturn(newAccount);

        // Act
        CreateAccountResponse response = accountService.createAccount(request);

        // Assert
        assertEquals(1L, response.getId());
        assertEquals("Jane Smith", response.getName());
        assertEquals(BigDecimal.valueOf(0.0), response.getBalance());
    }
}