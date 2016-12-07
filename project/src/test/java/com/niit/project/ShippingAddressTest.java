package com.niit.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.niit.project.Dao.ShippingAddressDao;
import com.niit.project.Dao.UserDao;
import com.niit.project.model.ShippingAddress;
import com.niit.project.model.User;

@Component
public class ShippingAddressTest {
	
public static void main(String[] args) {
		
		
		
		//you have to get Dao and domain object instance
		//but without using new operators
		// first you want to get context
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		//ask the context to get the instances/bean
		
		//you have to specify in which package the classes are there
		
		context.scan("com.niit.project");
		context.refresh();
		
		ShippingAddressDao shippingAddressDao = (ShippingAddressDao) context.getBean("shippingAddressDaoimpl");
		
		ShippingAddress shippingAddress = (ShippingAddress) context.getBean("shippingAddress");
		
		shippingAddress.setAddress("khvkjvkhvjy");
		shippingAddress.setEmailid("guru@gmail.com");
		shippingAddress.setId("22");
		shippingAddress.setName("guru");
		shippingAddress.setPhoneNo("8807872213");
		shippingAddress.setZipCode("603210");
		
		shippingAddressDao.saveOrUpdate(shippingAddress);
		
		System.out.println("objects are created sucessfully");
		
}
		

}
