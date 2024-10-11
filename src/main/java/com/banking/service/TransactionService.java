package com.banking.service;

import com.banking.model.Transaction;

import java.util.List;

public interface TransactionService {
	Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(Long transactionId, Transaction transaction);
    Transaction getTransactionById(Long transactionId);
    List<Transaction> getAllTransactions();
    void deleteTransaction(Long transactionId);


}
