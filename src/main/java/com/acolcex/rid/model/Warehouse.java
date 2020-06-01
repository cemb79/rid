package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Depositos")
public class Warehouse {

	@Id
	private String codDeposito;
	private String nombreDeposito;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	public String getCodDeposito() {
		return codDeposito;
	}
	public void setCodDeposito(String codDeposito) {
		this.codDeposito = codDeposito;
	}
	public String getNombreDeposito() {
		return nombreDeposito;
	}
	public void setNombreDeposito(String nombreDeposito) {
		this.nombreDeposito = nombreDeposito;
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
		result = prime * result + ((codDeposito == null) ? 0 : codDeposito.hashCode());
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
		Warehouse other = (Warehouse) obj;
		if (codDeposito == null) {
			if (other.codDeposito != null)
				return false;
		} else if (!codDeposito.equals(other.codDeposito))
			return false;
		return true;
	}
	
	
}
