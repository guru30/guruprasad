package com.niit.project.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.project.model.Supplier;


@Repository
@Component
public class SupplierDaoimpl implements SupplierDao {

	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
		
	
	@Transactional
	public void delete(String id){
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(supplierToDelete);
	}
	
	@Transactional
	public Supplier get(String id){
		String hql = "from Supplier where id ='"+ id +"'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) (query).list();
		
		if (listSupplier != null && !listSupplier.isEmpty()){
			return listSupplier.get(0);
		}
		return null;
	}
    @Transactional
    public List<Supplier> list(){
    	@SuppressWarnings({ "unchecked" })
    	List<Supplier> listSupplier = (List<Supplier>)
    	sessionFactory.getCurrentSession().createCriteria(Supplier.class)
    	.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    	return listSupplier;
    }
    @Transactional
	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);		
	}

}
