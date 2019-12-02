package org.cedam.application.randonnees.dao;

import java.util.List;
import java.util.Optional;

import org.cedam.application.randonnees.dao.config.AppConfig;
import org.cedam.application.randonnees.entity.TrekV2;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest
//@Ignore
public class TrekTest {

	@Autowired
	private TrekV2Dao object;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Transactional
	public void SaveTest() {
		TrekV2 trekV2 = new TrekV2();
		trekV2.setName("name");
		trekV2.setLocation("location");
		TrekV2 trekResult = object.save(trekV2);
		Assert.assertTrue(trekResult!=null);
		Assert.assertTrue(trekResult.getId()>0);	 
	}

	@Test
	@Transactional
	public void FindTest() {
		//Insert
		TrekV2 trekV2 = new TrekV2();
		trekV2.setName("name");	
		trekV2.setLocation("location");
		object.save(trekV2);
		
		// Find a customer by ID
		Optional<TrekV2> result = object.findById(1L);
		Assert.assertTrue(!result.isEmpty());	 
		Assert.assertTrue(result.isPresent());	 
		
		// Find customers by last name
		List<TrekV2> result2 = object.findByName("name");
		Assert.assertTrue(!result2.isEmpty());	 
		Assert.assertTrue(result2.size()>0);		
		
	}
	
	
	
//	public boolean test() {
//		// Save a new customer
//
//		TrekV2 newTrek = new TrekV2();
//		newTrek.setLocation("location");
//		newTrek.setName("Smith");		
//		trekV2Dao.save(newTrek);
//		
//		
//		
//		// Find a customer by ID
//		Optional<TrekV2> result = trekV2Dao.findById(1L);
//		result.ifPresent(new Consumer<TrekV2>() {
//			public void accept(TrekV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// Find customers by last name
//		List<TrekV2> customers = trekV2Dao.findByName("Smith");
//		customers.forEach(new Consumer<TrekV2>() {
//			public void accept(TrekV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// List all customers
//		Iterable<TrekV2> iterator = trekV2Dao.findAll();
//		iterator.forEach(new Consumer<TrekV2>() {
//			public void accept(TrekV2 customer) {
//				System.out.println(customer);
//			}
//		});
//		
//		// Count number of customer
//		long count = trekV2Dao.count();
//		System.out.println("Number of trek: " + count);
//		
//		return true;
//	}


}
