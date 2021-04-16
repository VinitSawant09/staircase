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
		
		return staircaseUtil.calculateMinStrides(flights, stepsPerStride);
		
	}
	
	public Staircase storeStridesRequest(Staircase objStaircaseVO)
	{
		
		
		return staircaseDAO.storeStridesRequest(objStaircaseVO);
		
	}
	
	public List<OutputVO> getAllRequests(long threshold,  int limit)
	{
		List<Staircase> list = new ArrayList<Staircase>();
		List<OutputVO> listOutputVO = null;
		
		list = staircaseDAO.getAllRequests(threshold, limit);
		listOutputVO =staircaseUtil.transformOutput(list);
		return listOutputVO;
		
	}
	
	

}
