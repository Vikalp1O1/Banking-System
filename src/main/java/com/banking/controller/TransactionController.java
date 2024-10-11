package com.banking.controller;

import com.banking.model.Transaction;
import com.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
	 private final TransactionService transactionService;

	    @Autowired
	    public TransactionController(TransactionService transactionService) {
	        this.transactionService = transactionService;
	    }

	    @PostMapping
	    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
	        Transaction createdTransaction = transactionService.createTransaction(transaction);
	        return ResponseEntity.ok(createdTransaction);
	    }

	    @GetMapping("/{transactionId}")
	    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionId) {
	        Transaction transaction = transactionService.getTransactionById(transactionId);
	        return ResponseEntity.ok(transaction);
	    }

	    @GetMapping
	    public ResponseEntity<List<Transaction>> getAllTransactions() {
	        List<Transaction> transactions = transactionService.getAllTransactions();
	        return ResponseEntity.ok(transactions);
	    }

	    @PutMapping("/{transactionId}")
	    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long transactionId, @RequestBody Transaction transaction) {
	        Transaction updatedTransaction = transactionService.updateTransaction(transactionId, transaction);
	        return ResponseEntity.ok(updatedTransaction);
	    }

	    @DeleteMapping("/{transactionId}")
	    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
	        transactionService.deleteTransaction(transactionId);
	        return ResponseEntity.noContent().build();
	    }

}
