package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UsuariosRID")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuarioID")
	private String id;
	@Column(name = "usuarioPwd")
	private String password;
	@Column(name = "usuarioIDNo")
	private String username;
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
