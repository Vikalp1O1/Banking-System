package com.banking.controller;


import com.banking.LoginResponse;
import com.banking.model.User;

import com.banking.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    


    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
    	 user.setAccountNumber("ACC" + System.currentTimeMillis()); // Example account number generation
         
         System.out.println("Registering user: " + user.getUsername() + ", Account Number: " + user.getAccountNumber() + ", Balance: " + user.getBalance());

         
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User loginRequest) {
        System.out.println("Login attempt for username: " + loginRequest.getUsername());
        
        User user = userService.findByUsername(loginRequest.getUsername());
        if (user != null) {
            System.out.println("User found: " + user.getUsername());
            System.out.println("Stored Password: " + user.getPassword());
            System.out.println("Entered Password: " + loginRequest.getPassword());
            
         // Create a LoginResponse with the user details (including accountNumber and balance)
            LoginResponse loginResponse = new LoginResponse(user);
            return ResponseEntity.ok(loginResponse);
               
            }
        
        return ResponseEntity.status(401).body("Bad credentials");
       
    }
    
    // New endpoint to fetch user account details
    @GetMapping("/account/{username}")
    public ResponseEntity<User> getUserDetails(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        }else {
        return ResponseEntity.status(404).body(null); // Return 404 if the user is not found
    }
}

}