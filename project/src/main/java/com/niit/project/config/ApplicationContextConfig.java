package com.niit.project.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.project.Dao.CartDao;
import com.niit.project.Dao.CartDaoimpl;
import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.CategoryDaoimpl;
import com.niit.project.Dao.CreditCardDao;
import com.niit.project.Dao.CreditCardDaoimpl;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.ProductDaoimpl;
import com.niit.project.Dao.ShippingAddressDao;
import com.niit.project.Dao.ShippingAddressDaoimpl;
import com.niit.project.Dao.SupplierDao;
import com.niit.project.Dao.SupplierDaoimpl;
import com.niit.project.Dao.UserDao;
import com.niit.project.Dao.UserDaoimpl;
import com.niit.project.model.Cart;
import com.niit.project.model.Category;
import com.niit.project.model.CreditCard;
import com.niit.project.model.Customer;
import com.niit.project.model.Product;
import com.niit.project.model.ShippingAddress;
import com.niit.project.model.Supplier;
import com.niit.project.model.User;




@Configuration
@ComponentScan("com.niit.project")
@EnableTransactionManagement
public class ApplicationContextConfig {	
	@Autowired
	@Bean(name="dataSource")
		    public DataSource getH2DataSource() {
			 DriverManagerDataSource dataSource=new DriverManagerDataSource();
			 dataSource.setDriverClassName("org.h2.Driver");
		    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test14");
		    	dataSource.setUsername("sa");
		    	dataSource.setPassword("");
		    	return dataSource;
		    }
		    

	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
		}
		   
		    
		    @Autowired
		    @Bean(name = "sessionFactory")
		    public SessionFactory getSessionFactory(DataSource dataSource) {
		    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		    	sessionBuilder.addProperties(getHibernateProperties());
		    	sessionBuilder.addAnnotatedClasses(Category.class);
		    	sessionBuilder.addAnnotatedClasses(Supplier.class);
		    	sessionBuilder.addAnnotatedClasses(Product.class);
		    	sessionBuilder.addAnnotatedClasses(Cart.class);
		    	sessionBuilder.addAnnotatedClasses(User.class);
		    	sessionBuilder.addAnnotatedClasses(ShippingAddress.class);
		    	sessionBuilder.addAnnotatedClasses(Customer.class);
		    	sessionBuilder.addAnnotatedClasses(CreditCard.class);
	
		    	//sessionBuilder.addAnnotatedClasses(CardDetails.class);

				return sessionBuilder.buildSessionFactory();
		    }
		 
			@Autowired
			@Bean(name = "transactionManager")
			public HibernateTransactionManager getTransactionManager(
					SessionFactory sessionFactory) {
				HibernateTransactionManager transactionManager = new HibernateTransactionManager(
						sessionFactory);

				return transactionManager;
			}
				
			
		    
		 
@Autowired
@Bean(name="categoryDao")
public CategoryDao getCategoryDao(SessionFactory sessionFactory){
	return new CategoryDaoimpl(sessionFactory);
}
@Autowired
@Bean(name="supplierDao")
public SupplierDao getSupplierDao(SessionFactory sessionFactory){
	return new SupplierDaoimpl(sessionFactory);
}
@Autowired
@Bean(name="productDao")
public ProductDao getProductDao(SessionFactory sessionFactory)
{
	return new ProductDaoimpl(sessionFactory);
}
@Autowired(required=true)
@Bean(name="userDao")
public UserDao getUserDao(SessionFactory sessionFactory)
{
	return new UserDaoimpl(sessionFactory);
	
}
@Autowired(required=true)
@Bean(name="cartDao")
public CartDao getCartDao(SessionFactory sessionFactory){
	return new CartDaoimpl(sessionFactory);
}
@Autowired(required=true)
@Bean(name="shippingAddressDao")
public ShippingAddressDao getShippingAddressDao(SessionFactory sessionFactory){
	return new ShippingAddressDaoimpl(sessionFactory);
}

@Autowired(required=true)
@Bean(name="creditCardDao")
public CreditCardDao getCreditCardDao(SessionFactory sessionFactory){
	return new CreditCardDaoimpl(sessionFactory);
}
}