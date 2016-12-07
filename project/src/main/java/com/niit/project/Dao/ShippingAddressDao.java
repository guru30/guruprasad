package com.niit.project.Dao;

import java.util.List;

import com.niit.project.model.ShippingAddress;



public interface ShippingAddressDao {
	
public List<ShippingAddress> list(String id);
	
	public ShippingAddress get(String name);
	
	public void saveOrUpdate(ShippingAddress shippingAddress);
	
	public void delete(String id);
	
	public void editShippingAddress(ShippingAddress shippingAddress);
	

}
