package com.acolcex.rid.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DO")
public class DeliveryOrder {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer regDO;
	private String codSucursal;
	private String noDO;
	private Date fechaRegistro;
	private String tipoOperacion;
	private String codEstadoDO;
	private String usuarioID;
	private String codCliente;
	private String codModalidadDO;
	private Date fecVenModTemp;
	private String codTipoDeclaracion;
	private String noPedido;
	private String codMercancia;
	private String codTransporte;
	private String docTransporte;
	private String codPuerto;
	private String codDeposito;
	private String manifiesto;
	private Date manifiestoFecha;
	private String manifiestoVencimiento;
	private String codEmpRefiere;
	private String codTerminoNegociacion;
	private String codMoneda;
	private BigDecimal valor;
	private String observaciones;
	private String descripcionMercancia;
	private String usuarioIDStamp;
	private Date dateStamp;
	
	public Integer getRegDO() {
		return regDO;
	}
	public void setRegDO(Integer regDO) {
		this.regDO = regDO;
	}
	public String getCodSucursal() {
		return codSucursal;
	}
	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}
	public String getNoDO() {
		return noDO;
	}
	public void setNoDO(String noDO) {
		this.noDO = noDO;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getCodEstadoDO() {
		return codEstadoDO;
	}
	public void setCodEstadoDO(String codEstadoDO) {
		this.codEstadoDO = codEstadoDO;
	}
	public String getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(String usuarioID) {
		this.usuarioID = usuarioID;
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public String getCodModalidadDO() {
		return codModalidadDO;
	}
	public void setCodModalidadDO(String codModalidadDO) {
		this.codModalidadDO = codModalidadDO;
	}
	public Date getFecVenModTemp() {
		return fecVenModTemp;
	}
	public void setFecVenModTemp(Date fecVenModTemp) {
		this.fecVenModTemp = fecVenModTemp;
	}
	public String getCodTipoDeclaracion() {
		return codTipoDeclaracion;
	}
	public void setCodTipoDeclaracion(String codTipoDeclaracion) {
		this.codTipoDeclaracion = codTipoDeclaracion;
	}
	public String getNoPedido() {
		return noPedido;
	}
	public void setNoPedido(String noPedido) {
		this.noPedido = noPedido;
	}
	public String getCodMercancia() {
		return codMercancia;
	}
	public void setCodMercancia(String codMercancia) {
		this.codMercancia = codMercancia;
	}
	public String getCodTransporte() {
		return codTransporte;
	}
	public void setCodTransporte(String codTransporte) {
		this.codTransporte = codTransporte;
	}
	public String getDocTransporte() {
		return docTransporte;
	}
	public void setDocTransporte(String docTransporte) {
		this.docTransporte = docTransporte;
	}
	public String getCodPuerto() {
		return codPuerto;
	}
	public void setCodPuerto(String codPuerto) {
		this.codPuerto = codPuerto;
	}
	public String getCodDeposito() {
		return codDeposito;
	}
	public void setCodDeposito(String codDeposito) {
		this.codDeposito = codDeposito;
	}
	public String getManifiesto() {
		return manifiesto;
	}
	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}
	public Date getManifiestoFecha() {
		return manifiestoFecha;
	}
	public void setManifiestoFecha(Date manifiestoFecha) {
		this.manifiestoFecha = manifiestoFecha;
	}
	public String getManifiestoVencimiento() {
		return manifiestoVencimiento;
	}
	public void setManifiestoVencimiento(String manifiestoVencimiento) {
		this.manifiestoVencimiento = manifiestoVencimiento;
	}
	public String getCodEmpRefiere() {
		return codEmpRefiere;
	}
	public void setCodEmpRefiere(String codEmpRefiere) {
		this.codEmpRefiere = codEmpRefiere;
	}
	public String getCodTerminoNegociacion() {
		return codTerminoNegociacion;
	}
	public void setCodTerminoNegociacion(String codTerminoNegociacion) {
		this.codTerminoNegociacion = codTerminoNegociacion;
	}
	public String getCodMoneda() {
		return codMoneda;
	}
	public void setCodMoneda(String codMoneda) {
		this.codMoneda = codMoneda;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getDescripcionMercancia() {
		return descripcionMercancia;
	}
	public void setDescripcionMercancia(String descripcionMercancia) {
		this.descripcionMercancia = descripcionMercancia;
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
		result = prime * result + ((regDO == null) ? 0 : regDO.hashCode());
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
		DeliveryOrder other = (DeliveryOrder) obj;
		if (regDO == null) {
			if (other.regDO != null)
				return false;
		} else if (!regDO.equals(other.regDO))
			return false;
		return true;
	}
	
}
