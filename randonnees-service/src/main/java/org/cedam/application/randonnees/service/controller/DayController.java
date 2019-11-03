package org.cedam.application.randonnees.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayController {

	@RequestMapping("/day")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : day";
	}

	
	/*
	 * Day getById(Long id);
	 * 
	 * List<Day> listDays();
	 * 
	 * void insert(Day day);
	 * 
	 * long update(Day day);
	 */
}