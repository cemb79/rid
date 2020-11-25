package com.acolcex.rid.model.dto;

public class DeliveryOrderStatusDTO {

	private String status;
	private String name;
	private int numStatus;
	
	public DeliveryOrderStatusDTO() {
		
	}
		
	public DeliveryOrderStatusDTO(String status, String name, int numStatus) {
		super();
		this.status = status;
		this.name = name;
		this.numStatus = numStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(int numStatus) {
		this.numStatus = numStatus;
	}
	
}
