package org.cedam.application.randonnees.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccueilController {

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		Boolean a = true;
		if (a) {
			return "Futur application randonnées";
		}
		
		return "No futur";
	}

}