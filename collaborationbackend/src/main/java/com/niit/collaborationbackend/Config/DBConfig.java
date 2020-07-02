package com.niit.collaborationbackend.Config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
	
	@Configuration
	@EnableTransactionManagement
	@ComponentScan(basePackages="com.niit")
	public class DBConfig {
		@Bean
		public DataSource myDataSource() {
			BasicDataSource basicDataSource = new BasicDataSource();
			basicDataSource.setDriverClassName("org.h2.Driver");
			basicDataSource.setUrl("jdbc:h2:~/Collaboration");
			basicDataSource.setUsername("sa");
			basicDataSource.setPassword("password");
			return basicDataSource;
		}

		
		Properties myDBProperties() {
			Properties properties = new Properties();
			properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.H2Dialect");
			properties.setProperty(Environment.HBM2DDL_AUTO, "update");
			properties.setProperty(Environment.SHOW_SQL, "true");
			return properties;
		}

		@Bean(name ="sessionfactory")
		LocalSessionFactoryBean mySessionFactory() {
			LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
			localSessionFactoryBean.setDataSource(myDataSource());
			localSessionFactoryBean.setHibernateProperties(myDBProperties());
			localSessionFactoryBean.setPackagesToScan("com.niit.collaborationbackend.Modal");

			return localSessionFactoryBean;
		}
		
		@Autowired
		@Bean
		HibernateTransactionManager enableTransanction(SessionFactory sessionfactory)
		{
			HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
			hibernateTransactionManager.setSessionFactory(sessionfactory); 
			return hibernateTransactionManager;
		}
	}



