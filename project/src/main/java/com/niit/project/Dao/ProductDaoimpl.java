package com.niit.project.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.Product;

//@EnableTransactionManagement
@Repository
@Component
public class ProductDaoimpl implements ProductDao {
	
	@Autowired
	private Product product;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
   
	
	@Transactional
	public void delete(String id){
		Product productToDelete = new Product();
		productToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(productToDelete);
	}
	
    @Transactional
	public Product get(String id) {
		//select * from Ctegory where id= 'id'
				String hql = "from Category where id = '" + id +"'";
				Query query =sessionFactory.getCurrentSession().createQuery(hql);
				
				List<Product> list =query.list();
				
				if(list !=null || list.isEmpty())
				{
					return null;
				}
			       return list.get(0);
			}
    @Transactional
    public List<Product> list(){
    	@SuppressWarnings({"unchecked" })
    	List<Product> listProduct = (List<Product>)
    	sessionFactory.getCurrentSession().createCriteria(Product.class)
    	.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    	return listProduct;
    }
    @Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);		
	}
    
    @Transactional
    public List<Product> list(String category) {
    	String hql = "from Product where category='" + category + "'";
    	Query query = sessionFactory.getCurrentSession().createQuery(hql);
    	@SuppressWarnings("unchecked")
    	List<Product> listProduct = (List<Product>) query.list();
    	
    	return listProduct;

    }
}
