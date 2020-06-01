package com.acolcex.rid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MedioTransporte")
public class TransportationType {

	@Id
	private String codTransporte;
	private String nombreTransporte;
	private String usuarioIDStamp;
	private String dateStamp;
	
	public String getCodTransporte() {
		return codTransporte;
	}
	public void setCodTransporte(String codTransporte) {
		this.codTransporte = codTransporte;
	}
	public String getNombreTransporte() {
		return nombreTransporte;
	}
	public void setNombreTransporte(String nombreTransporte) {
		this.nombreTransporte = nombreTransporte;
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
		result = prime * result + ((codTransporte == null) ? 0 : codTransporte.hashCode());
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
		TransportationType other = (TransportationType) obj;
		if (codTransporte == null) {
			if (other.codTransporte != null)
				return false;
		} else if (!codTransporte.equals(other.codTransporte))
			return false;
		return true;
	}
	
}
