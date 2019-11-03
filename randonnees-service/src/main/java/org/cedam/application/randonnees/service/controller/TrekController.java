package org.cedam.application.randonnees.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrekController {

	@RequestMapping("/trek")
	@ResponseBody
	public String test() {
		return "Futur application randonnées : trek";
	}

}