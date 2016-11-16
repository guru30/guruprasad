package com.niit.project.Dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.Customer;


@Repository
public class CustomerDaoimpl implements CustomerDao{


		@Autowired
		SessionFactory sessionFactory;

		public CustomerDaoimpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@Transactional
		public void saveOrUpdate(Customer customer) {
			sessionFactory.getCurrentSession().saveOrUpdate(customer);

		}

		@Transactional
		public Customer get(String customerId) {
			return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);

		}

		public List<Customer> listCustomer() {
			String hql = "from Customer";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Customer> listOfCustomers = query.list();
			return listOfCustomers;
		}

		@Transactional
		public Customer getCustomerByUserName(String userName) {
			String hql = "from Customer where userName=" + "'" + userName + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Customer> listOfCustomers = query.list();
			if (listOfCustomers != null && !listOfCustomers.isEmpty()){
				return  listOfCustomers.get(0);
			}
				
			
			return null;

		}

		


}
