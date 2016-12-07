package com.niit.project.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.Product;
import com.niit.project.model.Supplier;

@Repository("productdaoimpl")
@Transactional
public class ProductDaoimpl implements ProductDao {
	
@Autowired
private SessionFactory sessionFactory;

public ProductDaoimpl(SessionFactory sessionFactory){
	this.sessionFactory = sessionFactory;
	}
	public List<Product> list() {
		@SuppressWarnings({"unchecked" })
		List<Product> listProduct = (List<Product>)
		sessionFactory.getCurrentSession().createCriteria(Product.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}
	public List<Product> list(String category) {
		return null;
		
	}
	public Product get(String product_Id) {
		String hql = "from Product where product_Id ='"+ product_Id +"'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) (query).list();
		
		if (listProduct != null && !listProduct.isEmpty()){
			return listProduct.get(0);
		}
		return null;
	}
	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	public void delete(String product_Id) {
		Product productToDelete = new Product();
		productToDelete.setProduct_Id(product_Id);
		sessionFactory.getCurrentSession().delete(productToDelete);
	}
	
}