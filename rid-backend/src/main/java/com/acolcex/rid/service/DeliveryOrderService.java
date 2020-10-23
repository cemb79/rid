package com.acolcex.rid.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.DeliveryOrderHistory;
import com.acolcex.rid.model.DeliveryOrderManagement;

public interface DeliveryOrderService extends CrudService<DeliveryOrder, Integer>{

	public Set<DeliveryOrder> findByUserId(String userId) throws ServiceException;
	
	public DeliveryOrderManagement findDOManagementByDOId(String doId) throws ServiceException;
	
	public Set<DeliveryOrderHistory> findDOHistoryByDOId(String doId) throws ServiceException;
	
	public Page<DeliveryOrder> findDOByCriteria(String userId, String criteria, Pageable pageable);
}
