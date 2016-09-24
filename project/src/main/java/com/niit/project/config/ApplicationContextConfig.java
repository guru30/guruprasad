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
	import org.springframework.orm.hibernate4.HibernateTransactionManager;
	import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
	import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.project.Dao.CategoryDao;
import com.niit.project.Dao.CategoryDaoimpl;
import com.niit.project.model.Category;

	

	@Configuration
	@ComponentScan("com.niit.project")
	@EnableTransactionManagement
	public class ApplicationContextConfig {
		
		
		
	  
		
		 @Bean(name = "H2dataSource")
		    public DataSource getH2DataSource() {
		    	BasicDataSource H2dataSource = new BasicDataSource();
		    	String url = "jdbc:h2:mem:~/test" +
		    	           "INIT=CREATE SCHEMA IF NOT EXISTS TEST";
		    	H2dataSource.setDriverClassName("org.h2.Driver");
		    	H2dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		    	H2dataSource.setUsername("sa");
		    	H2dataSource.setPassword("");
		    	
		    	return H2dataSource;
		    }
		   
		    
		    private Properties getHibernateProperties() {
		    	Properties properties = new Properties();
		    	properties.put("hibernate.show_sql", "true");
		    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		    	properties.put("hibernate.hdbm2ddl.auto","update");
		    	
		    	return properties;
		    }
		    
		    
		    @Autowired
		    @Bean(name = "sessionFactory")
		    public SessionFactory getSessionFactory(DataSource dataSource) {
		    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		    	sessionBuilder.addProperties(getHibernateProperties());
		    	sessionBuilder.addAnnotatedClasses(Category.class);
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
		    @Bean(name = "categoryDao")
		    public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		    	return new CategoryDaoimpl(sessionFactory);
		    }


		

	

}
