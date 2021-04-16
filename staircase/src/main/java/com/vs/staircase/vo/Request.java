package com.vs.staircase.vo;

import java.util.List;

public class Request {

	private List<Integer> flights;
	private int stepsPerStride;
	public List<Integer> getFlights() {
		return flights;
	}
	public void setFlights(List<Integer> flights) {
		this.flights = flights;
	}
	public int getStepsPerStride() {
		return stepsPerStride;
	}
	public void setStepsPerStride(int stepsPerStride) {
		this.stepsPerStride = stepsPerStride;
	}
}
