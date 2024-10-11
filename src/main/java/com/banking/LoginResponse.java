package com.banking;

import com.banking.model.User;

public class LoginResponse {
    private String username;
    private String accountNumber;
    private Double balance;

    // Constructor that extracts relevant details from the User object
    public LoginResponse(User user) {
        this.username = user.getUsername();
        this.accountNumber = user.getAccountNumber();
        this.balance = user.getBalance();
    }

    // Getters for the fields
    public String getUsername() {
        return username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    // Optionally, you can add setters if you need to modify these fields
}
