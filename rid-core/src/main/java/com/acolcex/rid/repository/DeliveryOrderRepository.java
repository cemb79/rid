package com.acolcex.rid.repository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acolcex.rid.model.DeliveryOrder;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {

	public Optional<DeliveryOrder> findByNoDO(String noDO);
	
	public Page<DeliveryOrder> findByUserId(String userId, Pageable pageable);
	
	@Query(value = "select * from DO where codPuerto = ?1 and codCliente = ?2 and codEstadoDO = 'ACT' order by FechaRegistro desc", nativeQuery = true)
	public Page<DeliveryOrder> findByPortIdAndClientId(String portId, String clientId, Pageable pageable);
	
	@Query(value = "select * from do where codCliente = ?1 and (DocTransporte like %?2% or NoDO like %?2% or NoPedido like %?2%)", nativeQuery = true)
	public Page<DeliveryOrder> searchByClientIdAndCriteria(String clientId, String criteria, Pageable pageable);
	
	@Query(value = "select do.* from do, usuariosRid u where do.codCliente = u.UsuarioID and CodCliente = ?2 and do.FechaRegistro between ?1 and DATEADD(month, 1, ?1)", nativeQuery = true)
	public Page<DeliveryOrder> findByPortIdAndRunningMonth(Date date, String clientId, Pageable pageable);
}
