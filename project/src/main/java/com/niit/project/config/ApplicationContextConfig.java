package com.niit.project.config;


	import java.util.Properties;


	import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
	import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.project.Dao.BillingAddressDao;
import com.niit.project.Dao.BillingAddressDaoimpl;
import com.niit.project.Dao.CardDetailDao;
import com.niit.project.Dao.CardDetailDaoimpl;
import com.niit.project.Dao.CartDao;
import com.niit.project.Dao.CartDaoimpl;
import com.niit.project.Dao.CartItemDao;
import com.niit.project.Dao.CartItemDaoimpl;
import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.CategoryDaoimpl;
import com.niit.project.Dao.CustomerDao;
import com.niit.project.Dao.CustomerDaoimpl;
import com.niit.project.Dao.OrderDao;
import com.niit.project.Dao.OrderDaoimpl;
import com.niit.project.Dao.OrderDetailDao;
import com.niit.project.Dao.OrderDetailDaoimpl;
import com.niit.project.Dao.OrderedItemsDao;
import com.niit.project.Dao.OrderedItemsDaoImpl;
import com.niit.project.Dao.ProductDao;
import com.niit.project.Dao.ProductDaoimpl;
import com.niit.project.Dao.ShippingAddressDao;
import com.niit.project.Dao.ShippingAddressDaoimpl;
import com.niit.project.Dao.SupplierDao;
import com.niit.project.Dao.SupplierDaoimpl;
import com.niit.project.Dao.UserDao;
import com.niit.project.Dao.UserDaoimpl;
import com.niit.project.model.BillingAddress;
import com.niit.project.model.CreditCard;
import com.niit.project.model.Cart;
import com.niit.project.model.CartItem;
import com.niit.project.model.Category;
import com.niit.project.model.Customer;
import com.niit.project.model.Order;
import com.niit.project.model.OrderDetail;
import com.niit.project.model.OrderedItems;
import com.niit.project.model.Product;
import com.niit.project.model.ShippingAddress;
import com.niit.project.model.Supplier;
import com.niit.project.model.User;

	

	@SuppressWarnings("unused")
	@Configuration
	@ComponentScan("com.niit.project")
	@EnableTransactionManagement
	public class ApplicationContextConfig {
		@Autowired
		@Bean(name = "dataSource")
		public DataSource getH2DataSource(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
			
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
		    	sessionBuilder.addAnnotatedClasses(User.class);
		    	sessionBuilder.addAnnotatedClasses(BillingAddress.class);
		    	sessionBuilder.addAnnotatedClasses(Customer.class);
		    	sessionBuilder.addAnnotatedClasses(CreditCard.class);
		    	sessionBuilder.addAnnotatedClasses(Cart.class);
		    	sessionBuilder.addAnnotatedClasses(CartItem.class);
		    	sessionBuilder.addAnnotatedClasses(OrderDetail.class);
		    	sessionBuilder.addAnnotatedClasses(OrderedItems.class);
		    	sessionBuilder.addAnnotatedClasses(Order.class);
		    	return sessionBuilder.buildSessionFactory();
		    		
		    }
		    
		    
		    
		    @Autowired
			@Bean(name = "transactionManager")
			public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
				HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
				return transactionManager;
				
			}
		    
		    @Autowired
		    @Bean(name = "categoryDao")
		    public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		    	return new CategoryDaoimpl(sessionFactory);
		    }

            @Autowired
            @Bean(name = "supplierDao")
            public SupplierDao getSupplierDao(SessionFactory sessionFactory){
            	return new SupplierDaoimpl(sessionFactory) ;
            }
		
            @Autowired
            @Bean(name = "productDao")
            public ProductDao getProductDao(SessionFactory sessionFactory){
            	return new ProductDaoimpl(sessionFactory);
            }
            
            @Autowired
            @Bean(name = "userDao")
            public UserDao getUserDao(SessionFactory sessionFactory){
            	return new UserDaoimpl(sessionFactory);
            }
            @Autowired
            @Bean(name = "cardDetailDao")
            public CardDetailDao getCardDetailDao(SessionFactory sessionFactory){
            	return new CardDetailDaoimpl(sessionFactory);
            }
            @Autowired
            @Bean(name = "cartDao")
            public CartDao getCartDao(SessionFactory sessionFactory){
            	return new CartDaoimpl(sessionFactory);
            }
            @Autowired
            @Bean(name = "cartItemDao")
            public CartItemDao getCartItemDao(SessionFactory sessionFactory){
            	return new CartItemDaoimpl(sessionFactory);
            }
            @Autowired
            @Bean(name = "customerDao")
            public CustomerDao getCustomerDao(SessionFactory sessionFactory){
            	return new CustomerDaoimpl(sessionFactory);
            }
            @Autowired
            @Bean(name = "orderDetailDao")
            public OrderDetailDao getOrderDetailDao(SessionFactory sessionFactory){
            	return new OrderDetailDaoimpl(sessionFactory);
            }
            @Autowired
            @Bean(name = "orderedItemsDao")
            public OrderedItemsDao getOrderedItemsDao(SessionFactory sessionFactory){
            	return new OrderedItemsDaoImpl(sessionFactory);
            }
            
            @Autowired
            @Bean(name = "shippingAddressDao")
            public ShippingAddressDao getShippingAddressDao(SessionFactory sessionFactory){
            	return new ShippingAddressDaoimpl(sessionFactory);
            }
            @Autowired
            @Bean(name = "billingAddressDao")
            public BillingAddressDao getBillingAddressDao(SessionFactory sessionFactory){
            	return new BillingAddressDaoimpl(sessionFactory);
            }
            @Autowired
            @Bean(name = "orderDao")
            public OrderDao getOrderDao(SessionFactory sessionFactory){
            	return new OrderDaoimpl(sessionFactory);
            }

}
