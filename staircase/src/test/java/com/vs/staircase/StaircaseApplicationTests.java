package com.vs.staircase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vs.staircase.service.StaircaseService;
import com.vs.staircase.util.StaircaseUtil;
import com.vs.staircase.vo.OutputVO;
import com.vs.staircase.vo.Request;
import com.vs.staircase.vo.Staircase;

@SpringBootTest
class StaircaseApplicationTests {

	@Autowired
	StaircaseService staircaseService;
	
	@Autowired
	StaircaseUtil staircaseUtil;
	
	@Test
	@Order(1) 
	void computeStridesWithNull() {
		
		 assertEquals(50,staircaseService.calculateMinStrides("4,9,8,11,7,20,14",2), "Wrong strides computed");
	}
	
	@Test
	@Order(2) 
	void storeStridesRequest() {
		
		 Staircase objStaircase = new Staircase();
		 objStaircase.setFlights("4,9,8,11,7,20,14");
		 objStaircase.setStepsPerStride(2);
		 assertEquals(objStaircase,staircaseService.storeStridesRequest(objStaircase), "Not registered");
		 List<OutputVO> listOutputVO = new ArrayList<OutputVO> ();
		 OutputVO objOutputVO =new OutputVO();
		 Request request = new Request();
		 List<Integer> list = staircaseUtil.transformStringToArray("4,9,8,11,7,20,14");
		 request.setFlights(list);
		 request.setStepsPerStride(2);
		 objOutputVO.setResult(50);
		 objOutputVO.setRequest(request);
		 listOutputVO.add(objOutputVO);
		 assertEquals(listOutputVO.size(),staircaseService.getAllRequests(50, 3).size(), "Wrong output");
	}
	
	
}
