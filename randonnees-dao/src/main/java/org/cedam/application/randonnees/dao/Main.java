package org.cedam.application.randonnees.dao;

import org.cedam.application.randonnees.businessV2.DayV2Business;
import org.cedam.application.randonnees.businessV2.TrekV2Business;
import org.cedam.application.randonnees.dao.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//appContext.scan("org.cedam.appplication.randonnees");
		//appContext.refresh();

		//CustomerService customerService = (CustomerService) appContext.getBean("customerService");
		//customerService.test();

		TrekV2Business trekV2Service = (TrekV2Business) appContext.getBean("trekV2Business");
		trekV2Service.test();
		
		DayV2Business dayV2Service = (DayV2Business) appContext.getBean("dayV2Business");
		dayV2Service.test();
		
		appContext.close();
	}

}
