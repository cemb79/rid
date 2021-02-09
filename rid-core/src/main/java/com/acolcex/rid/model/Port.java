package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DO")
public class Port {

	@Id
	private String codPuerto;
	private String nombrePuerto;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	public String getCodPuerto() {
		return codPuerto;
	}
	public void setCodPuerto(String codPuerto) {
		this.codPuerto = codPuerto;
	}
	public String getNombrePuerto() {
		return nombrePuerto;
	}
	public void setNombrePuerto(String nombrePuerto) {
		this.nombrePuerto = nombrePuerto;
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
}
