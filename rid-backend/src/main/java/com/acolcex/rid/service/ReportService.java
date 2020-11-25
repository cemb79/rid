package com.acolcex.rid.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;
import com.acolcex.rid.model.dto.DeliveryOrderStatusDTO;

public interface ReportService {

	public List<DeliveryOrderCityDTO> findViewDeliveryOrderGroupByCity(String userId);
	
	public Page<DeliveryOrder> findDeliveryOrderByPort(String port, String userId, Pageable pageable);
	
	public Page<DeliveryOrder> findDeliveryOrderByMonth(Date date, String userId, Pageable pageable);

	public List<DeliveryOrderStatusDTO> getDeliveryOrderStatusCount(String userId);
}
