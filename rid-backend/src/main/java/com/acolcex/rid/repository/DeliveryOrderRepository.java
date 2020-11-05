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
	
	public Set<DeliveryOrder> findByUserId(String userId);
	
	public Page<DeliveryOrder> findByPortIdAndClientId(String portId, String clientId, Pageable pageable);
	
	public Page<DeliveryOrder> findByClientIdAndDocTransporteContainingOrNoDOContainingOrNoPedidoContaining(String clientId, String docTran, String noDo, String noPedido, Pageable pageable);
	
	@Query(value = "select do.* from do, usuariosRid u where do.codCliente = u.UsuarioID and CodCliente = ?2 and do.FechaRegistro between ?1 and DATEADD(month, 1, ?1)", nativeQuery = true)
	public Page<DeliveryOrder> findByPortIdAndRunningMonth(Date date, String clientId, Pageable pageable);
}
