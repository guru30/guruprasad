package com.niit.project.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.OrderDetail;

@Component
@Repository
public class OrderDetailDaoimpl implements OrderDetailDao {
	
	
		@Autowired
		SessionFactory sessionFactory;

		public OrderDetailDaoimpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@Transactional
		public void saveOrUpdate(OrderDetail orderDetail) {
			sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);

		}

		@Transactional
		public void delete(String orderDetailId) {
			OrderDetail orderDetailTodelete = new OrderDetail();
			orderDetailTodelete.setOrderDetailId(orderDetailId);

		}

		@Transactional
		public List<OrderDetail> listOrderDetails() {
			String hql="from OrderDetail";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<OrderDetail> listOfOrderDetails = query.list();
			return listOfOrderDetails;
		}

		

	}

