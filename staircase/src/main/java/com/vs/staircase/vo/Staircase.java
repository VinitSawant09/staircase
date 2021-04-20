package com.vs.staircase.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Staircase")
public class Staircase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long result;
	private String flights;
    private int stepsPerStride;
    private Timestamp requestTime;

    // standard constructors / setters / getters / 
    
    public Staircase() {
		super();
		// TODO Auto-generated constructor stub
	} 
    
	public Staircase(long id, long result, String flights, int stepsPerStride, Timestamp requestTime) {
		super();
		this.id = id;
		this.result = result;
		this.flights = flights;
		this.stepsPerStride = stepsPerStride;
		this.requestTime = requestTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlights() {
		return flights;
	}

	public void setFlights(String flights) {
		this.flights = flights;
	}

	public int getStepsPerStride() {
		return stepsPerStride;
	}

	public void setStepsPerStride(int stepsPerStride) {
		this.stepsPerStride = stepsPerStride;
	}

	public Timestamp getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Staircase [id=" + id + ", result=" + result + ", flights=" + flights + ", stepsPerStride="
				+ stepsPerStride + ", requestTime=" + requestTime + "]";
	}

    
}
