package com.banking.service;

import com.banking.model.Customer;

import java.util.List;
public interface CustomerService {
	 Customer createCustomer(Customer customer);
	    Customer updateCustomer(Long customerId, Customer customer);
	    Customer getCustomerById(Long customerId);
	    List<Customer> getAllCustomers();
	    void deleteCustomer(Long customerId);

}
