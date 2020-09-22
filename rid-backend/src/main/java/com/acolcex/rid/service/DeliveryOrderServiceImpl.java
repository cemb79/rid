package com.acolcex.rid.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.repository.DeliveryOrderRepository;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {
	
	private DeliveryOrderRepository deliveryRepository;

	@Override
	public DeliveryOrder save(DeliveryOrder deliveryOrder) {
		DeliveryOrder response = deliveryRepository.save(deliveryOrder);
		return response;
	}

	@Override
	public Set<DeliveryOrder> findAll() {
		Set<DeliveryOrder> result = new HashSet<DeliveryOrder>();
		deliveryRepository.findAll().forEach(result::add);
		return result;
	}
	
	@Override
	public DeliveryOrder findById(Integer id) {
		Optional<DeliveryOrder> order = deliveryRepository.findById(id);
		return order.get();
	}

	@Autowired
	public void setDeliveryRepository(DeliveryOrderRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}

	@Override
	public void delete(DeliveryOrder object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<DeliveryOrder> findByUserId(String userId) {
		Set<DeliveryOrder> result = new HashSet<DeliveryOrder>();
		deliveryRepository.findByUserId(userId).forEach(result::add);
		return result;
	}

}
