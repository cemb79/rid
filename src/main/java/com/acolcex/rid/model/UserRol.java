package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UsuariosRol")
public class UserRol {

	@Id
	private String codRolUsuario;
	private String descripcionRolUsuario;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	
	public String getCodRolUsuario() {
		return codRolUsuario;
	}
	public void setCodRolUsuario(String codRolUsuario) {
		this.codRolUsuario = codRolUsuario;
	}
	public String getDescripcionRolUsuario() {
		return descripcionRolUsuario;
	}
	public void setDescripcionRolUsuario(String descripcionRolUsuario) {
		this.descripcionRolUsuario = descripcionRolUsuario;
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
