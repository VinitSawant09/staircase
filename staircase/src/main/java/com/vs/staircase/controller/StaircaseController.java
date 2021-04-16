package com.vs.staircase.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vs.staircase.service.StaircaseService;
import com.vs.staircase.vo.OutputVO;
import com.vs.staircase.vo.Staircase;

@RestController
public class StaircaseController {

	@Autowired
	StaircaseService staircaseService;
	
	@GetMapping("/stride")
	public ResponseEntity<Integer> calculateMinStrides(@RequestParam("flights") String flights, @RequestParam("stepsPerStride") int stepsPerStride)
	{
		int result = 0;
		Staircase objStaircaseVO = new Staircase();
		objStaircaseVO.setFlights(flights);
		objStaircaseVO.setStepsPerStride(stepsPerStride);
		
		result = staircaseService.calculateMinStrides(flights, stepsPerStride);
		if(result>0)
		{
			objStaircaseVO.setResult(result);
			System.out.println(staircaseService.storeStridesRequest(objStaircaseVO).getId());
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@GetMapping("/stride/request")
	public ResponseEntity<List<OutputVO>> getAllRequests(@RequestParam("threshold") long threshold, @RequestParam("limit") int limit)
	{
		
		List<OutputVO> listOutputVO= new ArrayList<OutputVO> ();	
		listOutputVO = staircaseService.getAllRequests(threshold, limit);
		
		return new ResponseEntity<>(listOutputVO,HttpStatus.OK);
	}
	
	
	
}
