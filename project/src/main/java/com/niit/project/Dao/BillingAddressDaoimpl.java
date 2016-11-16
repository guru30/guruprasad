package com.niit.project.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.BillingAddress;

@Component
@Repository
public class BillingAddressDaoimpl implements BillingAddressDao {
	



		@Autowired
		SessionFactory sessionFactory;

		public BillingAddressDaoimpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		
		@Transactional
		public void saveOrUpdate(BillingAddress billingAddress) {
			
			sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
			
		}
		@Transactional
		public BillingAddress getBillingAddress(String billingAddressId) {
			return (BillingAddress) sessionFactory.getCurrentSession().get(BillingAddress.class, billingAddressId);
		}

		
	

		@Transactional
		public void deleteBillingAddress(String billingAddressId) {
			BillingAddress billingAddressToDelete = new BillingAddress();
			billingAddressToDelete.setBillingAddressId(billingAddressId);
			sessionFactory.getCurrentSession().delete(billingAddressToDelete);

		}

		
		

	}


