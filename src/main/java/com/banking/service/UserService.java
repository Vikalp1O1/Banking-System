package com.banking.service;

import com.banking.model.User;
import com.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        user.setAccountNumber("ACC" + System.currentTimeMillis()); // Generate a unique account number
        // You may want to add validation and password encryption here
        return userRepository.save(user);
    }

    // Method to find a user by their username for login
    public User findByUsername(String username) {
        System.out.println("Fetching user for username: " + username);  // Log username input
        User user = userRepository.findByUsername(username);
        if (user != null) {
            System.out.println("User found: " + user.getUsername() + ", Balance: " + user.getBalance());
        } else {
            System.out.println("No user found with username: " + username);
        }
        return user;
    }

    // Method to find a user by their ID
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
}
