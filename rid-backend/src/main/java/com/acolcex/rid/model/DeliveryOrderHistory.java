package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DOEstados")
public class DeliveryOrderHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regNo;
	private String noDO;
	private Date fechaEstadoDO;
	private String estCompletado;
	private String encargado;
	private String observacionCliente;
	private String observaciones;
	private String usuarioIDStamp;
	private String ubicacion;
	private Date dateStamp;
	@ManyToOne
	@JoinColumn(name = "codEstOpeDO")
	private OperationState operationState;
	
	public Integer getRegNo() {
		return regNo;
	}
	public void setRegNo(Integer regNo) {
		this.regNo = regNo;
	}
	public String getNoDO() {
		return noDO;
	}
	public void setNoDO(String noDO) {
		this.noDO = noDO;
	}
	public Date getFechaEstadoDO() {
		return fechaEstadoDO;
	}
	public void setFechaEstadoDO(Date fechaEstadoDO) {
		this.fechaEstadoDO = fechaEstadoDO;
	}
	public String getEstCompletado() {
		return estCompletado;
	}
	public void setEstCompletado(String estCompletado) {
		this.estCompletado = estCompletado;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	public String getObservacionCliente() {
		return observacionCliente;
	}
	public void setObservacionCliente(String observacionCliente) {
		this.observacionCliente = observacionCliente;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getUsuarioIDStamp() {
		return usuarioIDStamp;
	}
	public void setUsuarioIDStamp(String usuarioIDStamp) {
		this.usuarioIDStamp = usuarioIDStamp;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Date getDateStamp() {
		return dateStamp;
	}
	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}
	public OperationState getOperationState() {
		return operationState;
	}
	public void setOperationState(OperationState operationState) {
		this.operationState = operationState;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryOrderHistory other = (DeliveryOrderHistory) obj;
		if (regNo == null) {
			if (other.regNo != null)
				return false;
		} else if (!regNo.equals(other.regNo))
			return false;
		return true;
	}

}
