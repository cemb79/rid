package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UsuariosRID")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String usuarioID;
	private String usuarioPwd;
	private Integer usuarioIDNo;
	private String usuarioNombre;
	private String usuarioROL;
	private String usuarioEmail;
	private boolean accesoRID;
	private boolean aprobador;
	private boolean usuarioActivo;
	private Date fechaIngreso;
	private Date fechaRetiro;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	public String getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(String usuarioID) {
		this.usuarioID = usuarioID;
	}
	public String getUsuarioPwd() {
		return usuarioPwd;
	}
	public void setUsuarioPwd(String usuarioPwd) {
		this.usuarioPwd = usuarioPwd;
	}
	public Integer getUsuarioIDNo() {
		return usuarioIDNo;
	}
	public void setUsuarioIDNo(Integer usuarioIDNo) {
		this.usuarioIDNo = usuarioIDNo;
	}
	public String getUsuarioNombre() {
		return usuarioNombre;
	}
	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}
	public String getUsuarioROL() {
		return usuarioROL;
	}
	public void setUsuarioROL(String usuarioROL) {
		this.usuarioROL = usuarioROL;
	}
	public String getUsuarioEmail() {
		return usuarioEmail;
	}
	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}
	public boolean isAccesoRID() {
		return accesoRID;
	}
	public void setAccesoRID(boolean accesoRID) {
		this.accesoRID = accesoRID;
	}
	public boolean isAprobador() {
		return aprobador;
	}
	public void setAprobador(boolean aprobador) {
		this.aprobador = aprobador;
	}
	public boolean isUsuarioActivo() {
		return usuarioActivo;
	}
	public void setUsuarioActivo(boolean usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaRetiro() {
		return fechaRetiro;
	}
	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
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
		result = prime * result + ((usuarioID == null) ? 0 : usuarioID.hashCode());
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
		User other = (User) obj;
		if (usuarioID == null) {
			if (other.usuarioID != null)
				return false;
		} else if (!usuarioID.equals(other.usuarioID))
			return false;
		return true;
	}
	
}
