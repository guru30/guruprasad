package com.niit.project.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.ShippingAddress;


	
	@Repository
	public class ShippingAddressDaoimpl implements ShippingAddressDao{

		
		@Autowired
		private SessionFactory sessionFactory;

		
		
		
		public ShippingAddressDaoimpl (SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}	

		@Transactional
		public List<ShippingAddress> list(String id) {
			String hql = "from ShippingAddress where id='" + id + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ShippingAddress> list = (List<ShippingAddress>) query.list();
			
			return list;
		}

		@Transactional
		public ShippingAddress get(String name) {
			String hql = "from ShippingAddress where name ='"+ name+"'";
			Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ShippingAddress> listShippingAddress = (List<ShippingAddress>) (query).list();
			
			if (listShippingAddress != null && !listShippingAddress.isEmpty()){
				return listShippingAddress.get(0);
			}
			return null;
		}

		@Transactional
		public void saveOrUpdate(ShippingAddress shippingAddress) {
			sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
		}

		@Transactional
		public void delete(String id) {
			ShippingAddress shippingAddressToDelete = new ShippingAddress();
			shippingAddressToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(shippingAddressToDelete);
		}

		@Transactional
		public void editShippingAddress(ShippingAddress shippingAddress) {
			sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
			
		}

	}



	
	
