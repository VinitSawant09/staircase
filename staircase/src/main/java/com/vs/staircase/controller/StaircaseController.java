package com.vs.staircase.controller;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vs.staircase.service.StaircaseService;
import com.vs.staircase.vo.ErrorVO;
import com.vs.staircase.vo.OutputVO;
import com.vs.staircase.vo.Staircase;

@RestController
public class StaircaseController {

	@Autowired
	StaircaseService staircaseService;
	
	/* 
	 * Method to compute strides based on string array of flights and integer steps per stride                       
	 */ 
	
	@GetMapping("/stride")
	public ResponseEntity<String> computeStrides(@RequestParam("flights") String flights, @RequestParam("stepsPerStride") int stepsPerStride
			)
	{
		int result = 0;
		Staircase objStaircaseVO = new Staircase();
		try
		{
		if(flights.contentEquals("0") || stepsPerStride<1 )
		{
			String msg = "computeStrides.request.flights[0].<list element>: must be greater than or equal to 1 |"
					+ "computeStrides.request.stepsPerStride: must be greater than or equal to 1";
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		objStaircaseVO.setFlights(flights);
		objStaircaseVO.setStepsPerStride(stepsPerStride);
		
		
		result = staircaseService.calculateMinStrides(flights, stepsPerStride);
		if(result>0)
		{
			objStaircaseVO.setResult(result);
			staircaseService.storeStridesRequest(objStaircaseVO).getId();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>(result+"",HttpStatus.OK);
	}
	

	/* 
	 * Method to get all request values based on  threshold and limit                          
	 */ 
	
	@GetMapping("/stride/request")
	public ResponseEntity<List<OutputVO>> getAllRequests(@RequestParam("threshold") long threshold, @RequestParam("limit") int limit,
			@RequestHeader("username") String username, @RequestHeader("password") String password
			)
	{
		try
		{
		if(username.equals( "username") && password.equals("password")  )
		{
			if(validate(threshold,limit))
			{
			List<OutputVO> listOutputVO= new ArrayList<OutputVO> ();	
			listOutputVO = staircaseService.getAllRequests(threshold, limit);
			return new ResponseEntity<>(listOutputVO,HttpStatus.OK);
			}
			else
			{
			 
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	/* 
	 * Method to validate values of threshold and limit aren't 0 or negative                          
	 */ 
	
	public boolean validate(long threshold, int limit)
	{
		return threshold>0 && limit>0; 	
	}
	
	
	
	
	/* 
	 * 
	 * Method to handle Missing Servlet Request Parameters and generating 400 Bad Request as response
	 * 
	 */ 
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorVO> handleMissingParams(MissingServletRequestParameterException ex) {
	    
		String name = ex.getParameterName();
	   
	    ErrorVO objErrorVO = new ErrorVO();
	    Date date= new Date();
        
		long time = date.getTime();
       
	    Timestamp ts = new Timestamp(time);
	   
	    objErrorVO.setTimestamp(ts);
	    objErrorVO.setStatus(400);
	    objErrorVO.setError("Bad Request");
	    objErrorVO.setMessage("Required parameter " +name + " is missing");
	    objErrorVO.setPath("/stride");
	   
	    return new ResponseEntity<>(objErrorVO,HttpStatus.OK) ;
	}
	
	
	
	
	
}
