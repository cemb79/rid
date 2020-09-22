package com.acolcex.rid.service;

import java.util.List;

import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;

public interface ReportService {

	public List<DeliveryOrderCityDTO> findViewDeliveryOrderGroupByCity(String userId);
}
