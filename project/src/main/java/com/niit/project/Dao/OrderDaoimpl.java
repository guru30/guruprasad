package com.niit.project.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.project.model.Order;

@Component
@Repository
public class OrderDaoimpl implements OrderDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDaoimpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    @Transactional
	public List<Order> list(String id) {
    	String hql = "from Order where email="+"'"+id+"' and status = "+"'N'";
    	Query query = sessionFactory.getCurrentSession().createQuery(hql);
    	List<Order> list = (List<Order>) query.list();
    	
		return list;
	}
    @Transactional
	public void saveOrUpdate(Order order) {
    	sessionFactory.getCurrentSession().saveOrUpdate(order);
		
	}
    @Transactional
	public String delete(String id) {
    	Order order = new Order();
    	order.setOrderID(id);
    	try{
    		sessionFactory.getCurrentSession().delete(order);
    	}catch (HibernateException e){
    		e.printStackTrace();
    		return e.getMessage();
    	}
		return null;
	}
    @Transactional
	public Order get(String id) {
		String hql = "from Order where email = "+"'"+id+"' and status = "+"'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Order> list = (List<Order>) query.list();
		
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}
    @Transactional
	public Long getTotalAmount(String id) {
    	String hql = "select sum(price) from Order where email="+"'"+id+"' and status = "+"'N'";
    	Query query = sessionFactory.getCurrentSession().createQuery(hql);
    	Long sum = (Long) query.uniqueResult();
 	
	return sum;
	}

}
