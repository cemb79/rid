package com.acolcex.rid.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acolcex.rid.model.DeliveryOrder;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {

	public Set<DeliveryOrder> findByUserId(String userId);
	
}
