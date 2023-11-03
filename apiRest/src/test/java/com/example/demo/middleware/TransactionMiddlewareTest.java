package com.example.demo.middleware;

import com.example.demo.middleware.TransactionMiddleware;
import com.example.demo.model.services.transaction.TransactionRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;
    /*
@RunWith(MockitoJUnitRunner.class)
public class TransactionMiddlewareTest {

    @InjectMocks
    private TransactionMiddleware transactionMiddleware;

    @Mock
    private Logger logger;


    @Test
    public void testProcessTransactionExceedsThreshold() {
        // Arrange
        TransactionRequest request = new TransactionRequest();
        request.setAccountNumber(1L);
        request.setTransactionType("deposit");
        request.setAmount(BigDecimal.valueOf(11000.0));

        // Act
        transactionMiddleware.processTransaction(request);

        // Assert
        verify(logger, times(1)).info("LIMIT EXCEEDED: More than 10.000$ deposited with account id: 1");
    }

    @Test
    public void testProcessTransactionDoesNotExceedThreshold() {
        // Arrange
        TransactionRequest request = new TransactionRequest();
        request.setAccountNumber(1L);
        request.setTransactionType("deposit");
        request.setAmount(BigDecimal.valueOf(5000.0));

        // Act
        transactionMiddleware.processTransaction(request);

        // Assert
        verify(logger, never()).info("LIMIT EXCEEDED: More than 10.000$ deposited with account id: 1");
    }

}
     */
