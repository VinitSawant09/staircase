package com.vs.staircase.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;



@Component
public class StaircaseUtil {

	
	public int calculateMinStrides(String flights, int stepsPerStride)
	{
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
		
		
		return minStridesRequired;
		
	}
}
