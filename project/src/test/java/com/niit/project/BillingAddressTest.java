package com.niit.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project.Dao.BillingAddressDao;
import com.niit.project.model.BillingAddress;


public class BillingAddressTest {
	
	public static void main(String[] args) {
	
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	context.scan("com.niit.project");
	context.refresh();
	
	BillingAddressDao billingAddressDao = (BillingAddressDao) context.getBean("billingAddressDaoimpl");
	
	BillingAddress billingAddress = (BillingAddress) context.getBean("billingAddress");
	
	billingAddress.setBillingAddressId("24");
	billingAddress.setCustomerId("02");
	billingAddress.setLine1("sdhfusdf");
	billingAddress.setLine2("hbkdbkjbsd");
	billingAddress.setCity("chennai");
	billingAddress.setCountry("india");
	billingAddress.setState("tamilnadu");
	billingAddress.setZipCode("600896");
	
     billingAddressDao.saveOrUpdate(billingAddress);
	
	
	
	System.out.println("objects are created sucessfully");
	}

}
