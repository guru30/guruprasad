package com.niit.project.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.CreditCard;

@Repository("CreditCardDao")
public class CreditCardDaoimpl implements CreditCardDao{
	
		@Autowired
		private SessionFactory sessionFactory;


		public CreditCardDaoimpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
			}

		@Transactional
		public void saveOrUpdate(CreditCard creditcard) {
			sessionFactory.getCurrentSession().saveOrUpdate(creditcard);
		}

		@Transactional
		public void delete(String name){
			CreditCard creditcardToDelete = new CreditCard();
			creditcardToDelete.setNameOnCard(name);
			sessionFactory.getCurrentSession().delete(creditcardToDelete);
		}

		@Transactional
		public CreditCard get(String id){
			String hql = "from CreditCard where id ='"+ id+"'";
			Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CreditCard> listCreditCard = (List<CreditCard>) (query).list();
			
			if (listCreditCard != null && !listCreditCard.isEmpty()){
				return listCreditCard.get(0);
			}
			return null;
		}

		@Transactional
		public List<CreditCard> list(){
			@SuppressWarnings({ "unchecked" })
			List<CreditCard> listCreditCard = (List<CreditCard>)
			sessionFactory.getCurrentSession().createCriteria(CreditCard.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listCreditCard;
		}

		public void editCreditCard(CreditCard creditcard) {

			sessionFactory.getCurrentSession().saveOrUpdate(creditcard);
		}



	}



