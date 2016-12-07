package com.niit.project.Dao;

import java.util.List;

import com.niit.project.model.OrderedItems;

public interface OrderedItemsDao {

	

		void saveOrUpdate(OrderedItems orderedItems );
		
		void delete(String orderedItemId);
		
		List<OrderedItems> listOrderedItems();
	}



