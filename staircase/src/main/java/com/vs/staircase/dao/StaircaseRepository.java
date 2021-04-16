package com.vs.staircase.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vs.staircase.vo.OutputVO;
import com.vs.staircase.vo.Staircase;

@Repository
public interface StaircaseRepository extends CrudRepository<Staircase, Long> {

	
	
}
