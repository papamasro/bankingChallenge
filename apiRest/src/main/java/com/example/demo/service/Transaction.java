package com.example.demo.service;

import com.example.demo.model.services.transaction.TransactionRequest;
import com.example.demo.model.services.transaction.TransactionResponse;

public interface Transaction {

    TransactionResponse createTransaction(TransactionRequest transactionRequest);
}
