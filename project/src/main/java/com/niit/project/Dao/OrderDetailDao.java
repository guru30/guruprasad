package com.niit.project.Dao;

import java.util.List;

import com.niit.project.model.OrderDetail;
public interface OrderDetailDao {

		void saveOrUpdate(OrderDetail orderDetail);

		void delete(String orderDetailId);

		List<OrderDetail> listOrderDetails();

	}



