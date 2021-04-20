package com.vs.staircase.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vs.staircase.dao.StaircaseDAO;
import com.vs.staircase.util.StaircaseUtil;
import com.vs.staircase.vo.OutputVO;
import com.vs.staircase.vo.Staircase;

@Component
public class StaircaseService {
	
	Logger logger = LogManager.getLogger(StaircaseService.class);
	
	@Autowired
	StaircaseUtil staircaseUtil;
	
	@Autowired
	StaircaseDAO staircaseDAO;
	
	public int calculateMinStrides(String flights, int stepsPerStride)
	{
		logger.info("Inside calculateMinStrides method");
		int result = 0;
		try
		{
		result = staircaseUtil.calculateMinStrides(flights, stepsPerStride);
		logger.info("Minimum Strides calculated was-"+result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		logger.info("End of calculateMinStrides method");
		return result;
				
	}
	
	public Staircase storeStridesRequest(Staircase objStaircaseVO)
	{
		logger.info("Inside storeStridesRequest method");
		Staircase staircaseObj = new Staircase();
		try
		{
			staircaseObj = staircaseDAO.storeStridesRequest(objStaircaseVO);
			logger.info(staircaseObj.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("End of storeStridesRequest method");
		return staircaseObj;
		
	}
	
	public List<OutputVO> getAllRequests(long threshold,  int limit)
	{
		
		logger.info("Inside getAllRequests method");
		List<Staircase> list = new ArrayList<Staircase>();
		List<OutputVO> listOutputVO = null;
		
		try
		{
		list = staircaseDAO.getAllRequests(threshold, limit);
		
		listOutputVO =staircaseUtil.transformOutput(list);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("End of getAllRequests method");
		return listOutputVO;
		
	}
	
	

}
