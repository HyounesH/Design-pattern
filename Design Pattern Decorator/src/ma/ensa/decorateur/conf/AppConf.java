package ma.ensa.decorateur.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ma.ensa.decorateur.dao.IDao;
import ma.ensa.decorateur.dao.IDaoImpl;

@Configuration
@ComponentScan("ma.ensa.decorateur.dao")
@EnableTransactionManagement
public class AppConf {
	

	@Bean(name="dao")
	public IDao getDao(){
	   IDaoImpl dao=new IDaoImpl();
       dao.setSessionFactory(getSessionFactory().getObject());
		return dao;
	}
	
	@Bean//(name="datasource")
	public DataSource getDataSource(){
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/decorateur");
		datasource.setUsername("root");
		datasource.setPassword("");
		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setAnnotatedPackages("ma.ensa.decorateur.entities");
		sessionFactory.setPackagesToScan("ma.ensa.decorateur.entities");
		return sessionFactory;
	}
	

	public Properties getHibernateProperties(){
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		return hibernateProperties;
	}
	
	@Autowired   
	@Bean
	public HibernateTransactionManager gettransatctionManager(){
		HibernateTransactionManager transctionManager = new HibernateTransactionManager();
		transctionManager.setSessionFactory(getSessionFactory().getObject());
		return transctionManager;
	}

}
