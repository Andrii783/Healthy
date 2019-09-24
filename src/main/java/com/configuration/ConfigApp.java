package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com")
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigApp {

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
        JpaTransactionManager manager = new JpaTransactionManager(factory);

        manager.setDataSource(dataSource());

        return manager;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//        emfb.setJpaVendorAdapter(jpaVendorAdapter());
        emfb.setPersistenceUnitName("healthy");

        return emfb;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/healthy");

        dataSource.setUsername("root");

        dataSource.setPassword("1234");

        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL55Dialect");
        adapter.setGenerateDdl(true);

        return adapter;
    }
}
