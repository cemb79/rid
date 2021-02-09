package com.acolcex.rid.repository;

import java.util.List;

import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;
import com.acolcex.rid.model.dto.DeliveryOrderStatusDTO;

public interface ReportRepository {

	public List<DeliveryOrderCityDTO> findViewDeliveryOrderGroupByCity(String userId);

	List<DeliveryOrderStatusDTO> getDeliveryOrderStatusCount(String userId);
}
