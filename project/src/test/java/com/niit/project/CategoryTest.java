 package com.niit.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.niit.project.Dao.CategoryDao;
import com.niit.project.model.Category;
import java.util.*;


@Component
public class CategoryTest  {

	
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
		
		CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDaoimpl");
		
		Category category = (Category) context.getBean("category");
		
		category.setId("58");
		category.setName("prasad");
		category.setDescription("Nothing can defend him  ");
	
	
		
		categoryDao.saveOrUpdate(category);
		
		
		
		System.out.println("objects are created sucessfully");
		
	}

}
