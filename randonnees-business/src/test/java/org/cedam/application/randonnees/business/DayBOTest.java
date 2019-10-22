package org.cedam.application.randonnees.business;

import java.util.List;

import org.cedam.application.randonnees.dao.config.AppConfig;
import org.cedam.application.randonnees.entity.Day;
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
public class DayBOTest {

	@Autowired
	private DayBO object;

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
	public void testGetById() {
		List<Day> listeDays = object.listDays();
		Day day = object.getById(listeDays.get(0).getId());
		Assert.assertNotNull(day);
		Assert.assertEquals(listeDays.get(0).getId(), day.getId());

		Day day2 = object.getById(listeDays.get(0).getId() + 1);
		Assert.assertNotNull(day2);
		Assert.assertNotEquals(listeDays.get(0).getId(), day2.getId());
	}

	
	@Test
	public void testListDays() {
		List<Day> listDays = object.listDays();
		Assert.assertNotNull(listDays);
	}

	
	@Test
	public void testInsert() {
		int numberBefore = object.listDays().size();
		Day dayA = new Day();
		dayA.setNumber("testA");
		object.insert(dayA);
		Assert.assertEquals(++numberBefore, object.listDays().size());
	}

	@Test
	@Transactional
	public void testUpdate() {
		int numberBefore = object.listDays().size();
		
		//Persistant
		double valeurNumberA = Math.random();
		Day dayA = object.listDays().get(0);
		dayA.setNumber(String.valueOf(valeurNumberA));
		long id = object.update(dayA);
		Assert.assertEquals(String.valueOf(valeurNumberA), object.getById(id).getNumber());
	
		//Détaché
		double valeurNumberB = Math.random();
		Day dayB = new Day();
		dayB.setId(2);
		dayB.setNumber(String.valueOf(valeurNumberB));
		long idB = object.update(dayB);
		Assert.assertEquals(String.valueOf(valeurNumberB), object.getById(idB).getNumber());
		
		Assert.assertEquals(numberBefore, object.listDays().size());
	}
}
