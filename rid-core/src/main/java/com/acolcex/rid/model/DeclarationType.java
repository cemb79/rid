package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoDeclaracionDO")
public class DeclarationType {

	@Id
	private String codTipoDeclaracion;
	private String nombreTipoDeclaracion;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	public String getCodTipoDeclaracion() {
		return codTipoDeclaracion;
	}
	public void setCodTipoDeclaracion(String codTipoDeclaracion) {
		this.codTipoDeclaracion = codTipoDeclaracion;
	}
	public String getNombreTipoDeclaracion() {
		return nombreTipoDeclaracion;
	}
	public void setNombreTipoDeclaracion(String nombreTipoDeclaracion) {
		this.nombreTipoDeclaracion = nombreTipoDeclaracion;
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
		result = prime * result + ((codTipoDeclaracion == null) ? 0 : codTipoDeclaracion.hashCode());
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
		DeclarationType other = (DeclarationType) obj;
		if (codTipoDeclaracion == null) {
			if (other.codTipoDeclaracion != null)
				return false;
		} else if (!codTipoDeclaracion.equals(other.codTipoDeclaracion))
			return false;
		return true;
	}
	
}
