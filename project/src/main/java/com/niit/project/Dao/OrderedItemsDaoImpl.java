package com.niit.project.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.OrderedItems;

@Component
@Repository
public class OrderedItemsDaoImpl implements OrderedItemsDao {
	

		@Autowired
		SessionFactory sessionFactory;

		public OrderedItemsDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@Transactional
		public void saveOrUpdate(OrderedItems orderedItems) {
			sessionFactory.getCurrentSession().saveOrUpdate(orderedItems);

		}

		@Transactional
		public void delete(String orderedItemId) {
			OrderedItems orderedItemsTodelete = new OrderedItems();
			orderedItemsTodelete.setOrderedItemId(orderedItemId);
			sessionFactory.getCurrentSession().delete(orderedItemsTodelete);

		}

		@Transactional
		public List<OrderedItems> listOrderedItems() {
			String hql="from OrderedItems";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<OrderedItems> listOfOrderedItems = query.list();
			return listOfOrderedItems;
		}

	}



