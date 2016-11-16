package com.niit.project.Dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.CartItem;

@Repository
public class CartItemDaoimpl implements CartItemDao {
	



		@Autowired
		SessionFactory sessionFactory;

		public CartItemDaoimpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public void saveOrUpdate(CartItem cartItem) {
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);

			
		}	

		@Transactional
		public void delete(String cartItemId) {
			CartItem cartItemToDelete = new CartItem();
			cartItemToDelete.setCartItemId(cartItemId);
			sessionFactory.getCurrentSession().delete(cartItemToDelete);
		}

		@Transactional
		public List<CartItem> getCartItemsByCustomerId(String customerId) {
			String hql = "from CartItem where customerId=" + "'" + customerId + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<CartItem> listOfCartItems = query.list();
			return listOfCartItems;
		}

		@Transactional
		public List<CartItem> listCartItems() {
			String hql = "from CartItem";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<CartItem> cartItems = query.list();
			return cartItems;

		}
		@Transactional
		public CartItem getCartItem(String cartItemId) {
			String hql = "from CartItem where cartItemId=" + "'" + cartItemId + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<CartItem> cartItemList = query.list();
			if(cartItemList!=null && !cartItemList.isEmpty())
				return cartItemList.get(0);
			return null;
		}
		
		
		
			
		}

