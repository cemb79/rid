package com.acolcex.rid.service;

import java.util.Set;

import com.acolcex.rid.model.DeliveryOrder;

public interface DeliveryOrderService extends CrudService<DeliveryOrder, Integer>{

	public Set<DeliveryOrder> findByUserId(String userId);
}
