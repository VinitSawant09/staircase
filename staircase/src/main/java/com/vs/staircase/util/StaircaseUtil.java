package com.vs.staircase.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import com.vs.staircase.vo.OutputVO;
import com.vs.staircase.vo.Request;
import com.vs.staircase.vo.Staircase;



@Component
public class StaircaseUtil {

	Logger logger = LogManager.getLogger(StaircaseUtil.class);
	/*
	 * The basic method to calculate minimum Strides logic
	 * 
	 */
	
	public int calculateMinStrides(String flights, int stepsPerStride)
	{
		logger.info("Inside calculateMinStrides method");
		int minStridesRequired = 0;
		List<String> flightsSep = Arrays.asList(flights.split(","));
		
		minStridesRequired = minStridesRequired+ (flightsSep.size()-1)*2;
		
		for(String s: flightsSep)
		{
				int temp = Integer.parseInt(s);
			    if(temp%stepsPerStride == 0)
				   {
					   minStridesRequired = minStridesRequired +  temp / stepsPerStride;
				   }
			    else
				    {
			    	   minStridesRequired = minStridesRequired + (int) Math.ceil( temp / stepsPerStride)+1;
				    }
		}
		
		logger.info("End of calculateMinStrides method");
		return minStridesRequired;
		
	}
	
	/*
	 * Transform the database output to our custom List of OutputVO
	 * 
	 */
	
	public List<OutputVO> transformOutput(List<Staircase> list)
	{
		
		logger.info("Inside transformOutput method");
		List<OutputVO> listOutputVO = new ArrayList<OutputVO>();
		
		for(Staircase staircase :list)
		{
			OutputVO objOutputVO = new OutputVO();
			
			
			objOutputVO.setResult(staircase.getResult());
			Request objRequest = new Request();
			objRequest.setStepsPerStride(staircase.getStepsPerStride());
			
			List<Integer> intSteps = transformStringToArray(staircase.getFlights());
			objRequest.setFlights(intSteps);
			
			objOutputVO.setRequest(objRequest);
			
			listOutputVO.add(objOutputVO);
		}
		
		logger.info("End of transformOutput method");
		return listOutputVO;
	}
	
	/*
	 * 
	 * Transforming String of integers separated by commas to List of Integers
	 * 
	 */
	public List<Integer> transformStringToArray(String flights)
	{
        List<String> flightsSep = Arrays.asList(flights.split(","));
        List<Integer> list = new ArrayList<Integer>();
        for(String s :flightsSep)
		{
        	list.add(Integer.parseInt(s));
		}
		
		return list;
	}
}
