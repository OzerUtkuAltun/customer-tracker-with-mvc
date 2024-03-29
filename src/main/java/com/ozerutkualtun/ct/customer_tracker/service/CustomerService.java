package com.ozerutkualtun.ct.customer_tracker.service;

import com.ozerutkualtun.ct.customer_tracker.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(Integer customerId);

    void deleteCustomerById(Integer integer);
}
