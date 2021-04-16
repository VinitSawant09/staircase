package com.vs.staircase.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vs.staircase.vo.OutputVO;
import com.vs.staircase.vo.Staircase;
@Component
public class StaircaseDAO  {

	@Autowired
	StaircaseRepository staircaseRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public Staircase storeStridesRequest(Staircase objStaircaseVO) {
		
		Date date= new Date();
        
		long time = date.getTime();
       
	    Timestamp ts = new Timestamp(time);
	    objStaircaseVO.setRequestTime(ts);
		return staircaseRepository.save(objStaircaseVO);
       
       
    }
	
	public List<Staircase> getAllRequests(long threshold,  int limit)
	{
		
		TypedQuery<Staircase> query = entityManager.createQuery(
				  "FROM Staircase WHERE result<=:threshold" , Staircase.class);
				
		
		List<Staircase> listOfRecords = query.setParameter("threshold", threshold).setMaxResults(limit).getResultList();
		
		
		return listOfRecords;
		
	}
	
	
}
