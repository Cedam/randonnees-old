package org.cedam.application.randonnees.service.controler;

import org.cedam.application.randonnees.service.RandonneesServiceApplication;
import org.cedam.application.randonnees.service.controller.AccueilController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RandonneesServiceApplication.class)
public class AccueilControllerTest {

	@Autowired
	private AccueilController accueilController;
	
	@Before
	public void setUp() throws Exception {}
	
	@After
	public void tearDown() throws Exception {}
	
	@Test
	public void welcome() {
	    /*String payload = "{ \"products\": [{ \"name\": \"Mon produit\" }]}";
	    MockHttpServletRequestBuilder req = post(SERVICE_URI).contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON_UTF8)
	            .content(payload);
	    this.mockMvc.perform(req).andExpect(status().isOk());*/
		
		//Assert.("Futur application randonnées", accueilController.welcome());
		Assert.assertEquals("Futur application randonnées", accueilController.welcome());
	}

}
