package com.niit.project.Dao;

import java.util.List;

import com.niit.project.model.Customer;
public interface CustomerDao {
	

		void saveOrUpdate(Customer customer);
		
		Customer get(String customerId);
		
		List<Customer> listCustomer();
		
		Customer getCustomerByUserName(String userName);
	}


