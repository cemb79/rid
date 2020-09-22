package com.acolcex.rid.repository;

import java.util.List;

import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;

public interface ReportRepository {

	public List<DeliveryOrderCityDTO> findViewDeliveryOrderGroupByCity(String userId);
}
