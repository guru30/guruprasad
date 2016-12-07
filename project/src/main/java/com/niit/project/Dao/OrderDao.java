package com.niit.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.project.model.Order;

@Repository
public interface OrderDao {
	
	public List<Order> list(String id);
	public void saveOrUpdate(Order order);
	public String delete(String id);
	public Order get(String id);
	public Long getTotalAmount(String id);

}
