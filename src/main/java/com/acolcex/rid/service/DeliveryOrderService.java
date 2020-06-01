package com.acolcex.rid.service;

import java.util.List;

import com.acolcex.rid.model.DeliveryOrder;

public interface DeliveryOrderService {

	public List<DeliveryOrder> findAll();
	public Integer createDeliveryOrder(DeliveryOrder deliveryOrder);
}
