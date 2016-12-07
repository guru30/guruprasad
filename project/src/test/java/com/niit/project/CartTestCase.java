package com.niit.project;




import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project.Dao.CartDao;
import com.niit.project.Dao.CategoryDao;
import com.niit.project.model.Cart;
import com.niit.project.model.Category;

import junit.framework.Assert;



public class CartTestCase {
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Autowired
	CartDao cartDaoimpl; 
	
	@Autowired
	Cart cart;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.project");
		context.refresh();
		cart =(Cart) context.getBean("cart");
		cartDaoimpl =(CartDao) context.getBean("cartDaoimpl");
		
	}

	@Test
	public void deleteCartTestCase1()
	{
	//Assert.assertEquals(true, cartDaoimpl.delete("productName"));
	}
}
