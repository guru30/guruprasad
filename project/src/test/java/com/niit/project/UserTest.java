package com.niit.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.niit.project.Dao.UserDao;
import com.niit.project.model.User;

@Component
public class UserTest {


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
		
		UserDao userDao = (UserDao) context.getBean("userDaoimpl");
		
		User user = (User) context.getBean("user");
		
		user.setEmail("guru");
		user.setName("guru");
		user.setAddress("no s jain nagar");
		user.setPassword("guru");
		user.setMobile("8807872213");
		user.setRole("ROLE_ADMIN");
		user.setEnabled(true);
		user.setZipcode("603210");
		
	
		
		userDao.saveorupdate(user);
		
		
		
		System.out.println("objects are created sucessfully");
		
	}

}


