package com.ozerutkualtun.ct.customer_tracker.dao;

import com.ozerutkualtun.ct.customer_tracker.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomers();
}
