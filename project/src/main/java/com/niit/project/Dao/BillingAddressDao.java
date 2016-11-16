package com.niit.project.Dao;

import com.niit.project.model.BillingAddress;

public interface BillingAddressDao {
	
		void saveOrUpdate(BillingAddress billingAddress);

		void deleteBillingAddress(String billingAddressId);

		BillingAddress getBillingAddress(String billingAddressId);
	}



