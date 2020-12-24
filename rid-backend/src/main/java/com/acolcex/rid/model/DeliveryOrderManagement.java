package com.acolcex.rid.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOGestion")
public class DeliveryOrderManagement {

	@Id
	private String noDO;
	private Date fecEstSalida;
	private Date fecEstArribo;
	private Date fecArribo;
	private Date fecIngDepo;
	private Date fecCierre;
	private Date fecInsPreIni;
	private Date horInsPreIni;
	private String obsInsPreIni;
	private Date fecInsPreFin;
	private Date horInsPreFin;
	private String obsInsPreFin;
	private Date fecAce;
	private Date horAce;
	private Date fecAut;
	private Date horAut;
	private Date fecPagPre;
	private Date horPagPre;
	private Date fecSolAnt;
	private Date horSolAnt;
	private Date fecRecAnt;
	private Date horRecAnt;
	private Date fecLevAut;
	private Date horLevAut;
	private Date fecLevFis;
	private Date horLevFis;
	private Date fecAfoIni;
	private Date horAfoIni;
	private Date fecAfoFin;
	private Date horAfoFin;
	private Date fecEntFac;
	private Date horEntFac;
	private Date fecFac;
	private Date horFac;
	private Date fecRetMer;
	private Date horRetMer;
	private Date fecEntMer;
	private Date horEntMer;
	private String usuarioIDStamp;
	private Date dateStamp;
	private Integer noDeclaraciones;
	
	public String getNoDO() {
		return noDO;
	}
	public void setNoDO(String noDO) {
		this.noDO = noDO;
	}
	public Date getFecEstSalida() {
		return fecEstSalida;
	}
	public void setFecEstSalida(Date fecEstSalida) {
		this.fecEstSalida = fecEstSalida;
	}
	public Date getFecEstArribo() {
		return fecEstArribo;
	}
	public void setFecEstArribo(Date fecEstArribo) {
		this.fecEstArribo = fecEstArribo;
	}
	public Date getFecArribo() {
		return fecArribo;
	}
	public void setFecArribo(Date fecArribo) {
		this.fecArribo = fecArribo;
	}
	public Date getFecIngDepo() {
		return fecIngDepo;
	}
	public void setFecIngDepo(Date fecIngDepo) {
		this.fecIngDepo = fecIngDepo;
	}
	public Date getFecCierre() {
		return fecCierre;
	}
	public void setFecCierre(Date fecCierre) {
		this.fecCierre = fecCierre;
	}
	public Date getFecInsPreIni() {
		return fecInsPreIni;
	}
	public void setFecInsPreIni(Date fecInsPreIni) {
		this.fecInsPreIni = fecInsPreIni;
	}
	public Date getHorInsPreIni() {
		return horInsPreIni;
	}
	public void setHorInsPreIni(Date horInsPreIni) {
		this.horInsPreIni = horInsPreIni;
	}
	public String getObsInsPreIni() {
		return obsInsPreIni;
	}
	public void setObsInsPreIni(String obsInsPreIni) {
		this.obsInsPreIni = obsInsPreIni;
	}
	public Date getFecInsPreFin() {
		return fecInsPreFin;
	}
	public void setFecInsPreFin(Date fecInsPreFin) {
		this.fecInsPreFin = fecInsPreFin;
	}
	public Date getHorInsPreFin() {
		return horInsPreFin;
	}
	public void setHorInsPreFin(Date horInsPreFin) {
		this.horInsPreFin = horInsPreFin;
	}
	public String getObsInsPreFin() {
		return obsInsPreFin;
	}
	public void setObsInsPreFin(String obsInsPreFin) {
		this.obsInsPreFin = obsInsPreFin;
	}
	public Date getFecAce() {
		return fecAce;
	}
	public void setFecAce(Date fecAce) {
		this.fecAce = fecAce;
	}
	public Date getHorAce() {
		return horAce;
	}
	public void setHorAce(Date horAce) {
		this.horAce = horAce;
	}
	public Date getFecAut() {
		return fecAut;
	}
	public void setFecAut(Date fecAut) {
		this.fecAut = fecAut;
	}
	public Date getHorAut() {
		return horAut;
	}
	public void setHorAut(Date horAut) {
		this.horAut = horAut;
	}
	public Date getFecPagPre() {
		return fecPagPre;
	}
	public void setFecPagPre(Date fecPagPre) {
		this.fecPagPre = fecPagPre;
	}
	public Date getHorPagPre() {
		return horPagPre;
	}
	public void setHorPagPre(Date horPagPre) {
		this.horPagPre = horPagPre;
	}
	public Date getFecSolAnt() {
		return fecSolAnt;
	}
	public void setFecSolAnt(Date fecSolAnt) {
		this.fecSolAnt = fecSolAnt;
	}
	public Date getHorSolAnt() {
		return horSolAnt;
	}
	public void setHorSolAnt(Date horSolAnt) {
		this.horSolAnt = horSolAnt;
	}
	public Date getFecRecAnt() {
		return fecRecAnt;
	}
	public void setFecRecAnt(Date fecRecAnt) {
		this.fecRecAnt = fecRecAnt;
	}
	public Date getHorRecAnt() {
		return horRecAnt;
	}
	public void setHorRecAnt(Date horRecAnt) {
		this.horRecAnt = horRecAnt;
	}
	public Date getFecLevAut() {
		return fecLevAut;
	}
	public void setFecLevAut(Date fecLevAut) {
		this.fecLevAut = fecLevAut;
	}
	public Date getHorLevAut() {
		return horLevAut;
	}
	public void setHorLevAut(Date horLevAut) {
		this.horLevAut = horLevAut;
	}
	public Date getFecLevFis() {
		return fecLevFis;
	}
	public void setFecLevFis(Date fecLevFis) {
		this.fecLevFis = fecLevFis;
	}
	public Date getHorLevFis() {
		return horLevFis;
	}
	public void setHorLevFis(Date horLevFis) {
		this.horLevFis = horLevFis;
	}
	public Date getFecAfoIni() {
		return fecAfoIni;
	}
	public void setFecAfoIni(Date fecAfoIni) {
		this.fecAfoIni = fecAfoIni;
	}
	public Date getHorAfoIni() {
		return horAfoIni;
	}
	public void setHorAfoIni(Date horAfoIni) {
		this.horAfoIni = horAfoIni;
	}
	public Date getFecAfoFin() {
		return fecAfoFin;
	}
	public void setFecAfoFin(Date fecAfoFin) {
		this.fecAfoFin = fecAfoFin;
	}
	public Date getHorAfoFin() {
		return horAfoFin;
	}
	public void setHorAfoFin(Date horAfoFin) {
		this.horAfoFin = horAfoFin;
	}
	public Date getFecEntFac() {
		return fecEntFac;
	}
	public void setFecEntFac(Date fecEntFac) {
		this.fecEntFac = fecEntFac;
	}
	public Date getHorEntFac() {
		return horEntFac;
	}
	public void setHorEntFac(Date horEntFac) {
		this.horEntFac = horEntFac;
	}
	public Date getFecFac() {
		return fecFac;
	}
	public void setFecFac(Date fecFac) {
		this.fecFac = fecFac;
	}
	public Date getHorFac() {
		return horFac;
	}
	public void setHorFac(Date horFac) {
		this.horFac = horFac;
	}
	public Date getFecRetMer() {
		return fecRetMer;
	}
	public void setFecRetMer(Date fecRetMer) {
		this.fecRetMer = fecRetMer;
	}
	public Date getHorRetMer() {
		return horRetMer;
	}
	public void setHorRetMer(Date horRetMer) {
		this.horRetMer = horRetMer;
	}
	public Date getFecEntMer() {
		return fecEntMer;
	}
	public void setFecEntMer(Date fecEntMer) {
		this.fecEntMer = fecEntMer;
	}
	public Date getHorEntMer() {
		return horEntMer;
	}
	public void setHorEntMer(Date horEntMer) {
		this.horEntMer = horEntMer;
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
	public Integer getNoDeclaraciones() {
		return noDeclaraciones;
	}
	public void setNoDeclaraciones(Integer noDeclaraciones) {
		this.noDeclaraciones = noDeclaraciones;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noDO == null) ? 0 : noDO.hashCode());
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
		DeliveryOrderManagement other = (DeliveryOrderManagement) obj;
		if (noDO == null) {
			if (other.noDO != null)
				return false;
		} else if (!noDO.equals(other.noDO))
			return false;
		return true;
	}
}
