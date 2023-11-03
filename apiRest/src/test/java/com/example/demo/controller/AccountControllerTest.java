package com.example.demo.controller;

import com.example.demo.model.services.account.CreateAccountRequest;
import com.example.demo.model.services.account.CreateAccountResponse;
import com.example.demo.model.services.account.GetBalanceResponse;
import com.example.demo.service.impl.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAccount() {
        // Arrange
        CreateAccountRequest request = new CreateAccountRequest();
        request.setName("John Doe");

        CreateAccountResponse response = new CreateAccountResponse();
        response.setId(1L);

        when(accountService.createAccount(any(CreateAccountRequest.class))).thenReturn(response);

        // Act
        ResponseEntity<CreateAccountResponse> result = accountController.createAccount(request);

        // Assert
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(1L, result.getBody().getId().longValue());
    }

    @Test
    public void testGetBalance() {
        // Arrange
        Long accountId = 1L;
        GetBalanceResponse response = new GetBalanceResponse();
        response.setBalance(BigDecimal.valueOf(1000.0));

        when(accountService.getAccountBalance(accountId)).thenReturn(response);

        // Act
        ResponseEntity<GetBalanceResponse> result = accountController.getBalance(accountId);

        // Assert
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(BigDecimal.valueOf(1000.0), result.getBody().getBalance());
    }
}