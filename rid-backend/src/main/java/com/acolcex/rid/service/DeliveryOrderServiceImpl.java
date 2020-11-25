package com.acolcex.rid.service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.DeliveryOrderHistory;
import com.acolcex.rid.model.DeliveryOrderManagement;
import com.acolcex.rid.repository.DeliveryOrderHistoryRepository;
import com.acolcex.rid.repository.DeliveryOrderManagementRepository;
import com.acolcex.rid.repository.DeliveryOrderRepository;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {
	
	private DeliveryOrderRepository deliveryRepository;
	private DeliveryOrderManagementRepository doManagementRepository;
	private DeliveryOrderHistoryRepository doHistoryRespository;
	
	public DeliveryOrderServiceImpl(DeliveryOrderRepository deliveryRepository, DeliveryOrderManagementRepository doManagementRepository,
			DeliveryOrderHistoryRepository doHistoryRespository) {
		this.deliveryRepository = deliveryRepository;
		this.doManagementRepository = doManagementRepository;
		this.doHistoryRespository = doHistoryRespository;
	}

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
	public DeliveryOrder findById(Integer id) throws ServiceException {
		Optional<DeliveryOrder> order = deliveryRepository.findByNoDO(id.toString());
		try {
			return order.get();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
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

	@Override
	public DeliveryOrderManagement findDOManagementByDOId(String doId) throws ServiceException {
		Optional<DeliveryOrderManagement> result = doManagementRepository.findByNoDO(doId);
		try {
			return result.get();
		} catch (NoSuchElementException e) {
			return null;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Set<DeliveryOrderHistory> findDOHistoryByDOId(String doId) throws ServiceException {
		try {
			return doHistoryRespository.findByNoDO(doId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Page<DeliveryOrder> findDOByCriteria(String userId, String criteria, Pageable pageable) {
		Page<DeliveryOrder> page = Page.empty();
		if(!StringUtils.isEmpty(criteria)) {
			page = deliveryRepository.searchByClientIdAndCriteria(userId, criteria, pageable);
		}
		return page;
	}

}
