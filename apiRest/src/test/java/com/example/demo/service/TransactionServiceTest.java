package com.example.demo.service;

import com.example.demo.exception.InvalidAmountException;
import com.example.demo.exception.InvalidTransactionException;
import com.example.demo.model.entity.Accounts;
import com.example.demo.model.entity.Transactions;
import com.example.demo.model.services.transaction.TransactionRequest;
import com.example.demo.model.services.transaction.TransactionResponse;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.impl.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTransactionDeposit() {
        // Arrange
        TransactionRequest request = new TransactionRequest();
        request.setAccountNumber(1l);
        request.setTransactionType("deposit");
        request.setAmount(BigDecimal.valueOf(100.0));

        Accounts account = new Accounts();
        account.setId(1L);
        account.setName("John Doe");
        account.setBalance(BigDecimal.valueOf(1000.0));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        // Act
        TransactionResponse response = transactionService.createTransaction(request);

        // Assert
        assertEquals("John Doe", response.getName());
        assertEquals(BigDecimal.valueOf(1100.0), response.getBalance());
        verify(accountRepository, times(1)).save(account); // Verifica que se guardó la cuenta
        verify(transactionRepository, times(1)).save(any(Transactions.class)); // Verifica que se guardó la transacción
    }

    @Test
    public void testCreateTransactionRetire() {
        // Arrange
        TransactionRequest request = new TransactionRequest();
        request.setAccountNumber(1l);
        request.setTransactionType("retire");
        request.setAmount(BigDecimal.valueOf(500.0));

        Accounts account = new Accounts();
        account.setId(1L);
        account.setName("Jane Smith");
        account.setBalance(BigDecimal.valueOf(1000.0));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        // Act
        TransactionResponse response = transactionService.createTransaction(request);

        // Assert
        assertEquals("Jane Smith", response.getName());
        assertEquals(BigDecimal.valueOf(500.0), response.getBalance());
        verify(accountRepository, times(1)).save(account); // Verifica que se guardó la cuenta
        verify(transactionRepository, times(1)).save(any(Transactions.class)); // Verifica que se guardó la transacción
    }

    @Test(expected = InvalidAmountException.class)
    public void testCreateTransactionInsufficientBalance() {
        // Arrange
        TransactionRequest request = new TransactionRequest();
        request.setAccountNumber(1l);
        request.setTransactionType("retire");
        request.setAmount(BigDecimal.valueOf(1500.0));

        Accounts account = new Accounts();
        account.setId(1L);
        account.setName("Jane Smith");
        account.setBalance(BigDecimal.valueOf(1000.0));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        // Act
        transactionService.createTransaction(request);
    }
}