package com.acolcex.rid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TerminoNegociacionDO")
public class NegotiationTerms {

	@Id
	private String codTerminoNegociacion;
	private String nombreTerminoNegociacion;
	private String usuarioIDStamp;
	private String dateStamp;
	
	public String getCodTerminoNegociacion() {
		return codTerminoNegociacion;
	}
	public void setCodTerminoNegociacion(String codTerminoNegociacion) {
		this.codTerminoNegociacion = codTerminoNegociacion;
	}
	public String getNombreTerminoNegociacion() {
		return nombreTerminoNegociacion;
	}
	public void setNombreTerminoNegociacion(String nombreTerminoNegociacion) {
		this.nombreTerminoNegociacion = nombreTerminoNegociacion;
	}
	public String getUsuarioIDStamp() {
		return usuarioIDStamp;
	}
	public void setUsuarioIDStamp(String usuarioIDStamp) {
		this.usuarioIDStamp = usuarioIDStamp;
	}
	public String getDateStamp() {
		return dateStamp;
	}
	public void setDateStamp(String dateStamp) {
		this.dateStamp = dateStamp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codTerminoNegociacion == null) ? 0 : codTerminoNegociacion.hashCode());
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
		NegotiationTerms other = (NegotiationTerms) obj;
		if (codTerminoNegociacion == null) {
			if (other.codTerminoNegociacion != null)
				return false;
		} else if (!codTerminoNegociacion.equals(other.codTerminoNegociacion))
			return false;
		return true;
	}
	
}
