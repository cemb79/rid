package com.acolcex.rid.repository;

import org.springframework.data.repository.CrudRepository;

import com.acolcex.rid.model.DeliveryOrder;

public interface DeliveryOrderRepository extends CrudRepository<DeliveryOrder, Long> {

}
