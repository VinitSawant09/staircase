package com.vs.staircase.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	
	@RequestMapping("/")
	public String getLandingPage()
	{
		System.out.println("hello landing");
		return "staircaseLanding";
	}
}
