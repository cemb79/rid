package com.acolcex.rid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acolcex.rid.model.DeliveryOrderManagement;

public interface DeliveryOrderManagementRepository extends JpaRepository<DeliveryOrderManagement, String> {

	public Optional<DeliveryOrderManagement> findByNoDO(String noDO);
}
