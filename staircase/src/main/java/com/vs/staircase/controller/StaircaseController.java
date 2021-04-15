package com.vs.staircase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaircaseController {

	@GetMapping("/hello")
	public String helloWorld()
	{
		
		return "Hello World.!!";
	}
}
