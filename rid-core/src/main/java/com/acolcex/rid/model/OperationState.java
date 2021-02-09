package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EstadoOperacionDO")
public class OperationState {

	@Id	
	private String codEstOpeDO;
	private String nombreEstOpeDO;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	public String getCodEstOpeDO() {
		return codEstOpeDO;
	}
	public void setCodEstOpeDO(String codEstOpeDO) {
		this.codEstOpeDO = codEstOpeDO;
	}
	public String getNombreEstOpeDO() {
		return nombreEstOpeDO;
	}
	public void setNombreEstOpeDO(String nombreEstOpeDO) {
		this.nombreEstOpeDO = nombreEstOpeDO;
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
		result = prime * result + ((codEstOpeDO == null) ? 0 : codEstOpeDO.hashCode());
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
		OperationState other = (OperationState) obj;
		if (codEstOpeDO == null) {
			if (other.codEstOpeDO != null)
				return false;
		} else if (!codEstOpeDO.equals(other.codEstOpeDO))
			return false;
		return true;
	}
}
