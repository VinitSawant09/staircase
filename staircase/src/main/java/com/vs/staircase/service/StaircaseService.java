package com.vs.staircase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vs.staircase.dao.StaircaseDAO;
import com.vs.staircase.util.StaircaseUtil;
import com.vs.staircase.vo.OutputVO;
import com.vs.staircase.vo.Staircase;

@Component
public class StaircaseService {
	
	@Autowired
	StaircaseUtil staircaseUtil;
	
	@Autowired
	StaircaseDAO staircaseDAO;
	
	public int calculateMinStrides(String flights, int stepsPerStride)
	{
		int result = 0;
		try
		{
		result = staircaseUtil.calculateMinStrides(flights, stepsPerStride);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
				
	}
	
	public Staircase storeStridesRequest(Staircase objStaircaseVO)
	{
		Staircase staircaseObj = new Staircase();
		try
		{
			staircaseObj = staircaseDAO.storeStridesRequest(objStaircaseVO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return staircaseObj;
		
	}
	
	public List<OutputVO> getAllRequests(long threshold,  int limit)
	{
		
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
		return listOutputVO;
		
	}
	
	

}
