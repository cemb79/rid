package com.acolcex.rid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acolcex.rid.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Query(value = "select * from clientes where estadoCliente = 1 order by nombreRazonSocial", nativeQuery = true)
	public List<Customer> findActiveCustomers();
}
