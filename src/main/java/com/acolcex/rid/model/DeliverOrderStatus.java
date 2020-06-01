package com.acolcex.rid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EstadoDO")
public class DeliverOrderStatus {

	@Id
	private String codEstadoDO;
	private String nombreEstadoDO;
	
	public String getCodEstadoDO() {
		return codEstadoDO;
	}
	public void setCodEstadoDO(String codEstadoDO) {
		this.codEstadoDO = codEstadoDO;
	}
	public String getNombreEstadoDO() {
		return nombreEstadoDO;
	}
	public void setNombreEstadoDO(String nombreEstadoDO) {
		this.nombreEstadoDO = nombreEstadoDO;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEstadoDO == null) ? 0 : codEstadoDO.hashCode());
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
		DeliverOrderStatus other = (DeliverOrderStatus) obj;
		if (codEstadoDO == null) {
			if (other.codEstadoDO != null)
				return false;
		} else if (!codEstadoDO.equals(other.codEstadoDO))
			return false;
		return true;
	}
	
}
