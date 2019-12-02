package org.cedam.application.randonnees.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = { "org.cedam.application.randonnees.entity", "org.cedam.application.randonnees.dao", "org.cedam.application.randonnees.business", "org.cedam.application.randonnees.service", "org.cedam.application.randonnees.business" })
public class RandonneesServiceApplication {
// @SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration

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

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RandonneesServiceApplication.class, args);
		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(AppConfig.class);
	}

}
