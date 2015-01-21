package com.satvaimal.hellopersistence;
 
import com.satvaimal.hellopersistence.dao.AuthorDao;
import com.satvaimal.hellopersistence.dao.impl.AuthorDaoImpl;
import com.satvaimal.hellopersistence.service.AuthorService;
import com.satvaimal.hellopersistence.service.impl.AuthorServiceImpl;
 
import java.util.Properties;
 
import javax.persistence.EntityManagerFactory;
 
import javax.sql.DataSource;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.satvaimal.hellopersistence.repository")
public class AppConfig {
 
  @Bean
  public DataSource dataSource() {
 
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
    dataSource.setUrl( "jdbc:mysql://127.0.0.1:3306/hello_persistence" );
    dataSource.setUsername( "root" );
    dataSource.setPassword( "password" );
    return dataSource;
 
  }// End of method
 
  @Bean
  LocalContainerEntityManagerFactoryBean entityManagerFactory() {
 
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
        new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource( dataSource() );
    entityManagerFactoryBean.setJpaVendorAdapter(
        new HibernateJpaVendorAdapter() );
    entityManagerFactoryBean.setPackagesToScan(
        "com.satvaimal.hellopersistence.domain" );
 
    Properties jpaProperties = new Properties();
    jpaProperties.put( "hibernate.dialect",
        "org.hibernate.dialect.MySQLDialect" );
    jpaProperties.put( "hibernate.show_sql", "true" );
    jpaProperties.put( "hibernate.hbm2ddl.auto", "update" );
    entityManagerFactoryBean.setJpaProperties( jpaProperties );
 
    return entityManagerFactoryBean;
 
  }// End of method
 
  @Bean
  JpaTransactionManager transactionManager(
      EntityManagerFactory entityManagerFactory ) {
 
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory( entityManagerFactory );
    return transactionManager;
 
  }// End of method
 
  @Bean
  AuthorDao authorDao() {
    return new AuthorDaoImpl();
  }// End of method 

  @Bean
  public AuthorService authorService() {
    return new AuthorServiceImpl();
  }// End of method

}// End of class
