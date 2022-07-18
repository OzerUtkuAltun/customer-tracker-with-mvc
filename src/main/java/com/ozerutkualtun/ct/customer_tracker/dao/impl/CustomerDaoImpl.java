package com.ozerutkualtun.ct.customer_tracker.dao.impl;

import com.ozerutkualtun.ct.customer_tracker.dao.CustomerDao;
import com.ozerutkualtun.ct.customer_tracker.model.Customer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

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
        currentSession.saveOrUpdate(customer); // eğer yoksa ekle varsa update
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> query = currentSession.createQuery("from Customer c Where c.id = ?");

        query.setParameter(0, customerId);

        return query.getSingleResult();
    }

    @Override
    public void deleteCustomerById(Integer customerId) {

        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);

        if (!Objects.isNull(customer)) {
            session.delete(customer);
        }
    }
}
