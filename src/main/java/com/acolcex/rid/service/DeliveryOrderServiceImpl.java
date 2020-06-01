package com.acolcex.rid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.repository.DeliveryOrderRepository;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {
	
	@Autowired
	private DeliveryOrderRepository deliveryRepository;

	@Override
	public Integer createDeliveryOrder(DeliveryOrder deliveryOrder) {
		DeliveryOrder response = deliveryRepository.save(deliveryOrder);
		return response.getRegDO();
	}

	@Override
	public List<DeliveryOrder> findAll() {
		List<DeliveryOrder> result = new ArrayList<DeliveryOrder>();
		deliveryRepository.findAll().forEach(result::add);
		return result;
	}

}
