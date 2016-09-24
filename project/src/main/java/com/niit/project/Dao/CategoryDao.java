package com.niit.project.Dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.niit.project.model.Category;
@Repository
public interface CategoryDao {
	
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(String id);//1
	//public boolean delete(Category category);//2
	
	//based on the id,it will return category domain
     public Category get(String id);
     
     //to get all the categories
     
     public List<Category> list();

}
