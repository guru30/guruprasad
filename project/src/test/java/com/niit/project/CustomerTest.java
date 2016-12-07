package com.niit.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project.Dao.CustomerDao;
import com.niit.project.model.Customer;


public class CustomerTest {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.project");
		context.refresh();
		
		CustomerDao customerDao = (CustomerDao) context.getBean("customerDaoimpl");
		
		Customer customer = (Customer) context.getBean("customer");
		
		customer.setCustomerId("02");
		customer.setGender("male");
		customer.setPassword("guru3010");
		customer.setPhoneNo("8807872213");
		customer.setUsername("guru30@gmail.com");
		
	     customerDao.saveOrUpdate(customer);
		
		
		
		System.out.println("objects are created sucessfully");
		}

}
