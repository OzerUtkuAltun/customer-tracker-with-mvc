package com.ozerutkualtun.ct.customer_tracker.dao.impl;

import com.ozerutkualtun.ct.customer_tracker.dao.CustomerDao;
import com.ozerutkualtun.ct.customer_tracker.model.Customer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(customer);
    }
}
