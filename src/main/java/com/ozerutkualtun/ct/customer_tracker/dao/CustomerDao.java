package com.ozerutkualtun.ct.customer_tracker.dao;

import com.ozerutkualtun.ct.customer_tracker.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomers();

    void save(Customer customer);

    Customer getCustomerById(Integer customerId);

    void deleteCustomerById(Integer customerId);
}
