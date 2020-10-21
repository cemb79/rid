package com.acolcex.rid.service;

import java.util.Set;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.DeliveryOrderHistory;
import com.acolcex.rid.model.DeliveryOrderManagement;

public interface DeliveryOrderService extends CrudService<DeliveryOrder, Integer>{

	public Set<DeliveryOrder> findByUserId(String userId) throws ServiceException;
	
	public DeliveryOrderManagement findDOManagementByDOId(String doId) throws ServiceException;
	
	public Set<DeliveryOrderHistory> findDOHistoryByDOId(String doId) throws ServiceException;
}
