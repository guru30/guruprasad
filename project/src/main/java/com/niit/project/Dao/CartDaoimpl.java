package com.niit.project.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.Cart;



@Repository
public class CartDaoimpl implements CartDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDaoimpl(SessionFactory sessionFactory)  {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Cart> list(String id) {
		String hql = "from Cart where userId=" + "'" + id + "'   and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		
		return list;
	}

	@Transactional 
	public Cart get(String id) {
		String hql = "from Cart where userId=" + "'" + id + "'   and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	
	@Transactional
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		}
	
	
	@Transactional
	public void delete(String id){
		Cart cartToDelete = new Cart();
		cartToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(cartToDelete);
		
	}
	@Transactional
	public Long getTotalAmount(String id) {
	String hql = "select sum(price) from Cart where userId = " + "'" + id + "'" + "and status = '" + "N" +"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	Long sum = (Long) query.uniqueResult();
		return sum;
	}

	@Transactional
	public Long getCount(String username) {
		String hql ="select count(*) from Cart where userName = '" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long count = (Long) query.uniqueResult();
		return count;
	}

	

	
	
}
