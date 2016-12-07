package com.niit.project.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.CreditCard;

@Component
@Repository
public class CardDetailDaoimpl implements CardDetailDao {

		@Autowired
		private SessionFactory sessionFactory;

		public CardDetailDaoimpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		
		@Transactional
		public void saveOrUpdate(CreditCard cardDetail) {
	    sessionFactory.getCurrentSession().saveOrUpdate(cardDetail);
		}

	}



