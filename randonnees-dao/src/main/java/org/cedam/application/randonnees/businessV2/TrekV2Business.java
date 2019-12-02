package org.cedam.application.randonnees.businessV2;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.cedam.application.randonnees.dao.TrekV2Dao;
import org.cedam.application.randonnees.entity.TrekV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("trekV2Business")
public class TrekV2Business {
	
	@Autowired
	private TrekV2Dao trekV2Dao;
	
	public boolean test() {
		// Save a new customer

		TrekV2 newTrek = new TrekV2();
		newTrek.setLocation("location");
		newTrek.setName("Smith");		
		trekV2Dao.save(newTrek);
		
		
		
		// Find a customer by ID
		Optional<TrekV2> result = trekV2Dao.findById(1L);
		result.ifPresent(new Consumer<TrekV2>() {
			public void accept(TrekV2 customer) {
				System.out.println(customer);
			}
		});
		
		// Find customers by last name
		List<TrekV2> customers = trekV2Dao.findByName("Smith");
		customers.forEach(new Consumer<TrekV2>() {
			public void accept(TrekV2 customer) {
				System.out.println(customer);
			}
		});
		
		// List all customers
		Iterable<TrekV2> iterator = trekV2Dao.findAll();
		iterator.forEach(new Consumer<TrekV2>() {
			public void accept(TrekV2 customer) {
				System.out.println(customer);
			}
		});
		
		// Count number of customer
		long count = trekV2Dao.count();
		System.out.println("Number of trek: " + count);
		
		return true;
	}
}
