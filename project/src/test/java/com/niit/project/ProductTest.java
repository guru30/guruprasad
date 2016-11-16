package com.niit.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project.Dao.ProductDao;
import com.niit.project.model.Product;


public class ProductTest {
	
	public static void main(String[] args) {
		
		
@SuppressWarnings("resource")
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.project");
		context.refresh();
		
		ProductDao productDao = (ProductDao) context.getBean("productDaoimpl");
		
		Product product = (Product) context.getBean("product");
		
		product.setId("07");
		product.setName("iph");
		product.setPrice("876");
		product.setCategory_name("jithu");
		product.setSupplier_name("jithu");
		product.setDescription("this is cell");
		product.setProduct_Stock(25);
		
		
		productDao.saveOrUpdate(product);
		
		
		
		System.out.println("objects are created sucessfully");
	}

}
