package com.niit.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.project.model.Product;


@Repository
public interface ProductDao {
	
	public void saveOrUpdate(Product product);
	public void delete(String id);//1
	//public boolean delete(Category category);//2
	
	//based on the id,it will return category domain
     public Product get(String id);
     
     //to get all the categories
     
     public List<Product> list();

}
