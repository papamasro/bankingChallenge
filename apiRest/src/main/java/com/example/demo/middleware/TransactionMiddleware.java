package com.example.demo.middleware;

import com.example.demo.model.services.transaction.TransactionRequest;
import com.example.demo.service.impl.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransactionMiddleware {


    @Value("${transaction.threshold}")
    private String highAmountThreshold;  // min amount to logging

    private static final Logger logger = LoggerFactory.getLogger(TransactionMiddleware.class);


    public void processTransaction(TransactionRequest transaction) {
        double maxAmount = Double.parseDouble(highAmountThreshold);
        if ((transaction.getAmount().compareTo(BigDecimal.valueOf(maxAmount)) >= 0)) {
            logger.info("LIMIT EXCEEDED: More than 10.000$ deposited with account id: " + transaction.getAccountNumber());
        }
    }


}