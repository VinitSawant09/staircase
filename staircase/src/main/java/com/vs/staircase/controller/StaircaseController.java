package com.vs.staircase.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.staircase.service.StaircaseService;

@RestController
public class StaircaseController {

	@Autowired
	StaircaseService staircaseService;
	
	@GetMapping("/stride")
	public String helloWorld(@RequestParam("flights") String flights, @RequestParam("stepsPerStride") int stepsPerStride)
	{
		
		
		return staircaseService.calculateMinStrides(flights, stepsPerStride)+"";
	}
	
	
	
}
