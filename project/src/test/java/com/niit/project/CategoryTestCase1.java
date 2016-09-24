package com.niit.project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.CategoryDaoimpl;
import com.niit.project.model.Category;

import junit.framework.Assert;

public class CategoryTestCase1 {

	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Autowired
	CategoryDao categoryDaoimpl;
	
	@Autowired
	Category category;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		category =(Category) context.getBean("category");
		categoryDaoimpl =(CategoryDao) context.getBean("categoryDaoimpl");
		
	}
	@Test
	public void createCategoryTestCase1()
	{
		category.setId("lap01");
		category.setName("dell");
		category.setDescription("dell laptop");
		
		Assert.assertEquals("Create Category",true, categoryDaoimpl.save(category));
	}
	@Test
	public void updateCategoryTestCase1()
	{
		category.setId("lap01");
		category.setName("hp");
		category.setDescription("hp laptop");
		
		Assert.assertEquals(true,categoryDaoimpl.update(category) );
	}
	@Test
	public void deleteCategoryTestCase1()
	{
	Assert.assertEquals(true, categoryDaoimpl.delete("lapoq"));	
	}
    @Test
	public void getCategotyTestCase1()
	{
		Assert.assertEquals(true, categoryDaoimpl.get("lap01"));
		
	}
    @Test
    public void listCategoryTestCase1()
    {
    	Assert.assertEquals("List Category", 5, categoryDaoimpl.list().size());
    	
    }
}
