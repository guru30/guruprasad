package com.niit.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.project.model.Supplier;

@Repository
public interface SupplierDao {
	
	public void saveOrUpdate(Supplier category);
	public void delete(String id);//1
	//public boolean delete(Category category);//2
	
	//based on the id,it will return category domain
     public Supplier get(String id);
     //to get all the categories
     
     public List<Supplier> list();

}
