package com.vs.staircase.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vs.staircase.vo.Staircase;

@Component
public class StaircaseDAO  {

	Logger logger = LogManager.getLogger(StaircaseDAO.class);
	
	@Autowired
	StaircaseRepository staircaseRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	/* 
	 * 
	 * DAO Method to store the request in in memory databases table Staircase
	 * 
	 */
	public Staircase storeStridesRequest(Staircase objStaircaseVO) {
		logger.info("Inside storeStridesRequest method");
		try
		{
		Date date= new Date();
        
		long time = date.getTime();
       
	    Timestamp ts = new Timestamp(time);
	    
	    objStaircaseVO.setRequestTime(ts);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("End of storeStridesRequest method");
		return staircaseRepository.save(objStaircaseVO);
       
       
    }
	
	/* 
	 * 
	 * DAO Method to get all requests based on threshold and limit
	 * 
	 */
	
	public List<Staircase> getAllRequests(long threshold,  int limit)
	{
		logger.info("Inside getAllRequests method");
		TypedQuery<Staircase> query = null;
		List<Staircase> listOfRecords = null;
		try
		{
		query = entityManager.createQuery(
				  "FROM Staircase WHERE result<=:threshold" , Staircase.class);
				
		
	    listOfRecords = query.setParameter("threshold", threshold).setMaxResults(limit).getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("End of getAllRequests method");
		return listOfRecords;
		
	}
	
	
}
