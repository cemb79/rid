package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mercancias")
public class Goods {

	@Id
	private String codMercancia;
	private String nombreMercancia;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	public String getCodMercancia() {
		return codMercancia;
	}
	public void setCodMercancia(String codMercancia) {
		this.codMercancia = codMercancia;
	}
	public String getNombreMercancia() {
		return nombreMercancia;
	}
	public void setNombreMercancia(String nombreMercancia) {
		this.nombreMercancia = nombreMercancia;
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
		result = prime * result + ((codMercancia == null) ? 0 : codMercancia.hashCode());
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
		Goods other = (Goods) obj;
		if (codMercancia == null) {
			if (other.codMercancia != null)
				return false;
		} else if (!codMercancia.equals(other.codMercancia))
			return false;
		return true;
	}
	
}
