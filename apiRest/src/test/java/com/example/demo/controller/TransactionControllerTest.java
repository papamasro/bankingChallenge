package com.example.demo.controller;

import com.example.demo.middleware.TransactionMiddleware;
import com.example.demo.model.services.transaction.TransactionRequest;
import com.example.demo.model.services.transaction.TransactionResponse;
import com.example.demo.service.impl.TransactionService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionService transactionService;

    @Mock
    private TransactionMiddleware transactionMiddleware;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTransaction() {
        // Arrange
        TransactionRequest request = new TransactionRequest();
        request.setAmount(BigDecimal.valueOf(1000.0));

        TransactionResponse response = new TransactionResponse();
        response.setId(1L);

        when(transactionService.createTransaction(any(TransactionRequest.class))).thenReturn(response);

        // Act
        ResponseEntity<TransactionResponse> result = transactionController.createTransaction(request);

        // Assert
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(1L, result.getBody().getId().longValue());
        verify(transactionMiddleware, times(1)).processTransaction(request);
    }
}