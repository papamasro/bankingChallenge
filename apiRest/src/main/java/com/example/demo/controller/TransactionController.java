package com.example.demo.controller;

import com.example.demo.middleware.TransactionMiddleware;
import com.example.demo.model.services.transaction.TransactionRequest;
import com.example.demo.model.services.transaction.TransactionResponse;
import com.example.demo.service.impl.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TransactionController {
    TransactionService transactionService;

    TransactionMiddleware transactionLogger;

    @Autowired
    public TransactionController(TransactionService transactionService, TransactionMiddleware transactionLogger) {
        this.transactionService = transactionService;
        this.transactionLogger = transactionLogger;
    }

    @PostMapping("transactions")
    public ResponseEntity<TransactionResponse> createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        TransactionResponse createAccountResponse = transactionService.createTransaction(transactionRequest);
        transactionLogger.processTransaction(transactionRequest);
        return ResponseEntity.ok(createAccountResponse);
    }
}

