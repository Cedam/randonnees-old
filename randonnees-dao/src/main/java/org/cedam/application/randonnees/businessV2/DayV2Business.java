package org.cedam.application.randonnees.businessV2;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.cedam.application.randonnees.dao.DayV2Dao;
import org.cedam.application.randonnees.entity.DayV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dayV2Business")
public class DayV2Business {
	
	@Autowired
	private DayV2Dao dayV2Dao;
	
	public boolean test() {
		// Save a new customer
		DayV2 newDay = new DayV2();
		newDay.setNumber("number");		
		dayV2Dao.save(newDay);
		
		// Find a customer by ID
		Optional<DayV2> result = dayV2Dao.findById(1L);
		result.ifPresent(new Consumer<DayV2>() {
			public void accept(DayV2 customer) {
				System.out.println(customer);
			}
		});
		
		// Find customers by last name
		List<DayV2> customers = dayV2Dao.findByNumber("number");
		customers.forEach(new Consumer<DayV2>() {
			public void accept(DayV2 customer) {
				System.out.println(customer);
			}
		});
		
		// List all customers
		Iterable<DayV2> iterator = dayV2Dao.findAll();
		iterator.forEach(new Consumer<DayV2>() {
			public void accept(DayV2 customer) {
				System.out.println(customer);
			}
		});
		
		// Count number of customer
		long count = dayV2Dao.count();
		System.out.println("Number of day: " + count);
		
		return true;
	}
}
