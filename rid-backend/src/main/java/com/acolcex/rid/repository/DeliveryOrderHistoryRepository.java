package com.acolcex.rid.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acolcex.rid.model.DeliveryOrderHistory;

public interface DeliveryOrderHistoryRepository extends JpaRepository<DeliveryOrderHistory, String>{

	public Set<DeliveryOrderHistory> findByNoDO(String noDO);
}
