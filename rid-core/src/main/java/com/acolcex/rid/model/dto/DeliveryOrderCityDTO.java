package com.acolcex.rid.model.dto;

public class DeliveryOrderCityDTO {

	private String port;
	private String portName;
	private Integer numDO;
	
	public DeliveryOrderCityDTO(String port, String portName, Integer numDO) {
		super();
		this.port = port;
		this.portName = portName;
		this.numDO = numDO;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public Integer getNumDO() {
		return numDO;
	}
	public void setNumDO(Integer numDo) {
		this.numDO = numDo;
	}
}
