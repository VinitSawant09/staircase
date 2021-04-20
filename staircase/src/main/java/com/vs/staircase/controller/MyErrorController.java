package com.vs.staircase.controller;

import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*Customized error controller to handle 404,500 errors */ 

@Controller
public class MyErrorController implements ErrorController
{
	Logger logger = LogManager.getLogger(MyErrorController.class);
	
	
	 @RequestMapping("/error")
	    public String handleError(HttpServletRequest request) {
		 
		 logger.info("Inside handleError method");
		 Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		    
		    if (status != null) {
		        Integer statusCode = Integer.valueOf(status.toString());
		    
		        if(statusCode == HttpStatus.NOT_FOUND.value()) {
		            return "error404";
		        }
		        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
		            return "error500";
		        }
		    }
		    
		    logger.info("End of handleError method");
		    return "staircaseLanding";
	    }

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}


}