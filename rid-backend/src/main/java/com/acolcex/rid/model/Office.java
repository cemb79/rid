package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sucursal")
public class Office {

	@Id
	private String codSucursal;
	private String nombreSucursal;
	private Integer noSecuencialDO;
	private String codNoDo;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	public String getCodSucursal() {
		return codSucursal;
	}
	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public Integer getNoSecuencialDO() {
		return noSecuencialDO;
	}
	public void setNoSecuencialDO(Integer noSecuencialDO) {
		this.noSecuencialDO = noSecuencialDO;
	}
	public String getCodNoDo() {
		return codNoDo;
	}
	public void setCodNoDo(String codNoDo) {
		this.codNoDo = codNoDo;
	}
	public String getUsuarioIDStamp() {
		return usuarioIDStamp;
	}
	public void setUsuarioIDStamp(String usuarioIDStamp) {
		this.usuarioIDStamp = usuarioIDStamp;
	}
	public Date getDateStamp() {
		return dateStamp;
	}
	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codSucursal == null) ? 0 : codSucursal.hashCode());
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
		Office other = (Office) obj;
		if (codSucursal == null) {
			if (other.codSucursal != null)
				return false;
		} else if (!codSucursal.equals(other.codSucursal))
			return false;
		return true;
	}
	
}
