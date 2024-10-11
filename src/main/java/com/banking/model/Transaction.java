package com.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
public class Transaction {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long transactionId;

	    @Column(nullable = false)
	    private String transactionType;  // e.g., "DEPOSIT" or "WITHDRAWAL"

	    @Column(nullable = false)
	    private Double amount;

	    @Column(nullable = false)
	    private Date transactionDate;

	    private String description;

	    // Getters and Setters
	    public Long getTransactionId() {
	        return transactionId;
	    }

	    public void setTransactionId(Long transactionId) {
	        this.transactionId = transactionId;
	    }

	    public String getTransactionType() {
	        return transactionType;
	    }

	    public void setTransactionType(String transactionType) {
	        this.transactionType = transactionType;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }

	    public Date getTransactionDate() {
	        return transactionDate;
	    }

	    public void setTransactionDate(Date transactionDate) {
	        this.transactionDate = transactionDate;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

}
