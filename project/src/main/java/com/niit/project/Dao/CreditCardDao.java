package com.niit.project.Dao;

import java.util.List;

import com.niit.project.model.CreditCard;

public interface CreditCardDao {
	
	public List<CreditCard> list();
	
	public CreditCard get(String id);
	
	public void saveOrUpdate(CreditCard creditcard);
	
	public void delete(String id);
	
	public void editCreditCard(CreditCard creditcard);
	

}
