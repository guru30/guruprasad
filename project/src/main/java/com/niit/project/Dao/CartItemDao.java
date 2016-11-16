package com.niit.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.project.model.CartItem;

@Repository
public interface CartItemDao {
	

		void saveOrUpdate(CartItem cartItem);

		void delete(String cartItemId);

		CartItem getCartItem(String cartItemId);

		List<CartItem> getCartItemsByCustomerId(String customerId);

		List<CartItem> listCartItems();

	}


