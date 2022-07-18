package com.ozerutkualtun.ct.customer_tracker.service.impl;

import com.ozerutkualtun.ct.customer_tracker.dao.CustomerDao;
import com.ozerutkualtun.ct.customer_tracker.model.Customer;
import com.ozerutkualtun.ct.customer_tracker.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustoemr(Customer customer) {
        customerDao.save(customer);
    }
}
