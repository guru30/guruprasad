package com.niit.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project.Dao.SupplierDao;
import com.niit.project.model.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.project");
		context.refresh();
		
		SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDaoimpl");
		
		Supplier supplier = (Supplier) context.getBean("supplier");
		
		supplier.setId("50");
		supplier.setName("Samsun");
		supplier.setAddress("no 2 aagna street t");

		
		supplierDao.saveOrUpdate(supplier);
		
		
		
		System.out.println("objects are created sucessfully");
		
	}


}
