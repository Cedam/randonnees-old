package org.cedam.application.randonnees.dao;

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
public class DayDaoTest {

	@Autowired
	private DayDao object;

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
	public void testListDays() {
		List<Day> listDays = object.listDays();
		Assert.assertNotNull(listDays);
	}

	@Test
	@Transactional
	public void testAdd() {
		int numberBefore = object.listDays().size();
		Day dayA = new Day();
		dayA.setName("testA");

		object.add(dayA);

		Assert.assertTrue(++numberBefore == object.listDays().size());
	}

	@Test
	@Transactional
	public void testGetById() {
		List<Day> listeDays = object.listDays();
		Day day = object.getById(listeDays.get(0).getId());
		Assert.assertNotNull(day);
		Assert.assertEquals(listeDays.get(0).getId(), day.getId());

		Day day2 = object.getById(listeDays.get(0).getId() + 1);
		Assert.assertNotNull(day2);
		Assert.assertNotEquals(listeDays.get(0).getId(), day2.getId());
	}

}
