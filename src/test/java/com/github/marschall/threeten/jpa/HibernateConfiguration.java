package com.github.marschall.threeten.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import static com.github.marschall.threeten.jpa.Constants.PERSISTENCE_UNIT_NAME;

@Configuration
public class HibernateConfiguration {
  
//  @Autowired
//  private Environment environment;
  

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManager(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    bean.setPersistenceUnitName("threeten-jpa-hibernate");
//    bean.setPersistenceUnitName(environment.getProperty(PERSISTENCE_UNIT_NAME));
    bean.setJpaDialect(new HibernateJpaDialect());
    bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    bean.setDataSource(dataSource);
    return bean;
  }

}
