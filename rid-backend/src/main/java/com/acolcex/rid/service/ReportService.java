package com.acolcex.rid.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;

public interface ReportService {

	public List<DeliveryOrderCityDTO> findViewDeliveryOrderGroupByCity(String userId);
	
	public Page<DeliveryOrder> findDeliveryOrderByPort(String port, String userId, Pageable pageable);
}
