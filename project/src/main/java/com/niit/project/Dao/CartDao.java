package com.niit.project.Dao;

import java.util.List;

import com.niit.project.model.Cart;



public interface CartDao {

	public List<Cart> list(String id);
	
	public Cart get(String id);
	
	public void saveOrUpdate(Cart cart);
	
	public void delete(String id);
		
	public Long getTotalAmount(String id);
	
	public Long getCount(String username);
	
}
