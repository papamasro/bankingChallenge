package com.example.demo.service.impl;

import com.example.demo.exception.InvalidAmountException;
import com.example.demo.exception.InvalidTransactionException;
import com.example.demo.exception.UsernameNotFoundException;
import com.example.demo.model.entity.Accounts;
import com.example.demo.model.entity.Transactions;
import com.example.demo.model.services.transaction.TransactionRequest;
import com.example.demo.model.services.transaction.TransactionResponse;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.Transaction;
import com.example.demo.util.DateFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

import static java.lang.Long.parseLong;

@Service
public class TransactionService implements Transaction {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        logger.info("Calling create transaction service");
        Optional<Accounts> account = accountRepository.findById(transactionRequest.getAccountNumber());
        if (account.isPresent()) {
            if (transactionRequest.getTransactionType().contains("deposit")) {
                BigDecimal result = account.get().getBalance().add(transactionRequest.getAmount());
                account.get().setBalance(result);
            } else if (transactionRequest.getTransactionType().contains("retire")) {
                BigDecimal balanceCalculated = handleRetire(account.get().getBalance(), transactionRequest.getAmount());
                account.get().setBalance(balanceCalculated);
            } else {
                throw new InvalidTransactionException("the transaction is not allowed, type can be retire or deposit");
            }
            //save transactions
            accountRepository.save(account.get());
            Transactions newTransaction = new Transactions(account.get().getId(), transactionRequest.getTransactionType(), account.get().getBalance(), account.get().getName());
            transactionRepository.save(newTransaction);
            logger.info("transaction service success");
            return new TransactionResponse(account.get().getId(),  account.get().getName(),DateFormatter.getStringDate(), account.get().getBalance());
        } else {
            throw new UsernameNotFoundException("User not found to create transaction");
        }
    }

    public BigDecimal handleRetire(BigDecimal balance, BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            return balance.subtract(amount);
        } else {
            throw new InvalidAmountException("the transaction not finished, not enough money to extract");
        }
    }

}
