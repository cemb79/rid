package com.acolcex.rid.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DO")
public class DeliveryOrder {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String regDO;
	@ManyToOne
	@JoinColumn(name = "CodSucursal")
	private Office office;
	private String noDO;
	private Date fechaRegistro;
	private String tipoOperacion;
	@ManyToOne
	@JoinColumn(name = "codEstadoDO")
	private Status status;
	@Column(name = "UsuarioID")
	private String userId;
	//@ManyToOne
	//@JoinColumn(name = "codCliente")
	@Column(name = "codCliente")
	private String clientId;
	private String codModalidadDO;
	private Date fecVenModTemp;
	private String codTipoDeclaracion;
	private String noPedido;
	//private String codMercancia;
	private String codTransporte;
	private String docTransporte;
	@Column(name = "codPuerto")
	private String portId;
	private String codDeposito;
	private String manifiesto;
	private Date manifiestoFecha;
	private String manifiestoVencimiento;
	private String codTerminoNegociacion;
	private String codMoneda;
	private BigDecimal valor;
	private String observaciones;
	private String descripcionMercancia;
	private String mercanciaSerial;
	private String declaracionAnticipada;
	private String inspeccionPrevia;
	private String usuarioIDStamp;
	private Date dateStamp;
	@ManyToOne
	@JoinColumn(name = "codMercancia")
	private Goods goods;
	
	public String getRegDO() {
		return regDO;
	}
	public void setRegDO(String regDO) {
		this.regDO = regDO;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
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
	/*public String getCodMercancia() {
		return codMercancia;
	}
	public void setCodMercancia(String codMercancia) {
		this.codMercancia = codMercancia;
	}*/
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
	public String getPortId() {
		return portId;
	}
	public void setPortId(String portId) {
		this.portId = portId;
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
	public String getMercanciaSerial() {
		return mercanciaSerial;
	}
	public void setMercanciaSerial(String mercanciaSerial) {
		this.mercanciaSerial = mercanciaSerial;
	}
	public String getDeclaracionAnticipada() {
		return declaracionAnticipada;
	}
	public void setDeclaracionAnticipada(String declaracionAnticipada) {
		this.declaracionAnticipada = declaracionAnticipada;
	}
	public String getInspeccionPrevia() {
		return inspeccionPrevia;
	}
	public void setInspeccionPrevia(String inspeccionPrevia) {
		this.inspeccionPrevia = inspeccionPrevia;
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
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	/*public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/
	
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
