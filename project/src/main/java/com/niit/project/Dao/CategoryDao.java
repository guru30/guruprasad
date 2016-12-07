package com.niit.project.Dao;

import java.util.List;

import com.niit.project.model.Category;

/**
 * 
 */


public interface CategoryDao {


	public List<Category> list();

	public Category get(String id);
	
	public Category getByName(String name);

	public void saveOrUpdate(Category category);

	public void delete(String id);


}
