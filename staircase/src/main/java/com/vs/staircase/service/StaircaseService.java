package com.vs.staircase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vs.staircase.util.StaircaseUtil;

@Component
public class StaircaseService {
	
	@Autowired
	StaircaseUtil staircaseUtil;
	
	public int calculateMinStrides(String flights, int stepsPerStride)
	{
		
		return staircaseUtil.calculateMinStrides(flights, stepsPerStride);
		
	}

}
