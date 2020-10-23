package com.acolcex.rid.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.acolcex.rid.model.DeliveryOrder;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {

	public Optional<DeliveryOrder> findByNoDO(String noDO);
	
	public Set<DeliveryOrder> findByUserId(String userId);
	
	public Page<DeliveryOrder> findByPortIdAndClientId(String portId, String clientId, Pageable pageable);
	
	public Page<DeliveryOrder> findByClientIdAndDocTransporteContainingOrNoDOContainingOrNoPedidoContaining(String clientId, String docTran, String noDo, String noPedido, Pageable pageable);
}
