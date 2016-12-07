package com.niit.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.niit.project.Dao.CartDao;
import com.niit.project.Dao.CategoryDao;
import com.niit.project.model.Cart;
import com.niit.project.model.Category;

@Component
public class CartTest {
	
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
		
		CartDao cartDao = (CartDao) context.getBean("cartDaoimpl");
		
		Cart cart = (Cart) context.getBean("cart");
		
		
		
		cartDao.delete("2");
		
		
		
		System.out.println("objects are created sucessfully");
		
	}

}
