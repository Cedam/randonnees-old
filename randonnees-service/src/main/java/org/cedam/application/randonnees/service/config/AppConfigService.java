package org.cedam.application.randonnees.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("org.cedam.application.randonnees.entity"), @ComponentScan("org.cedam.application.randonnees.dao"), @ComponentScan("org.cedam.application.randonnees.business"), @ComponentScan("org.cedam.application.randonnees.service") })
public class AppConfigService {

//	@Bean
//	public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
//		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//		factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
//		return factoryBean;
//	}
//
//	@Bean
//	public JpaTransactionManager geJpaTransactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
//		return transactionManager;
//	}
}
