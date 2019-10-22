package org.cedam.application.randonnees.business;

import java.util.List;

import org.cedam.application.randonnees.dao.config.AppConfig;
import org.cedam.application.randonnees.entity.Trek;
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
public class TrekBoTest {

	@Autowired
	private TrekBO object;

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
	public void testGetById() {
		List<Trek> listeTreks = object.listTreks();
		Trek trek = object.getById(listeTreks.get(0).getId());
		Assert.assertNotNull(trek);
		Assert.assertEquals(listeTreks.get(0).getId(), trek.getId());
		
		Trek trek2 = object.getById(listeTreks.get(0).getId()+1);
		Assert.assertNotNull(trek2);
		Assert.assertNotEquals(listeTreks.get(0).getId(), trek2.getId());
		
		/*for (Day day : trek.getDays()) {
			Assert.assertNotNull(day);
		}*/
	}
	
	
	@Test
	@Transactional
	public void testListTreks() {
		List<Trek> listTreks = object.listTreks();
		Assert.assertNotNull(listTreks);
	}

	
	@Test
	@Transactional
	public void testAdd() {
		int numberBefore = object.listTreks().size();
		Trek trekA = new Trek();
		trekA.setName("testA");
		object.insert(trekA);
		Assert.assertEquals(++numberBefore, object.listTreks().size());
	}

	@Test
	@Transactional
	public void testUpdate() {
		int numberBefore = object.listTreks().size();
		
		//Persistant
		double valeurNumberA = Math.random();
		Trek trekA = object.listTreks().get(0);
		trekA.setName(String.valueOf(valeurNumberA));
		long id = object.update(trekA);
		Assert.assertEquals(String.valueOf(valeurNumberA), object.getById(id).getName());
	
		//Détaché
		double valeurNumberB = Math.random();
		Trek trekB = new Trek();
		trekB.setId(2);
		trekB.setName(String.valueOf(valeurNumberB));
		long idB = object.update(trekB);
		Assert.assertEquals(String.valueOf(valeurNumberB), object.getById(idB).getName());
		
		Assert.assertEquals(numberBefore, object.listTreks().size());
	}

}
