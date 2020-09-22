package com.acolcex.rid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;
import com.acolcex.rid.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {
	
	private ReportRepository reportRepository;
	
	public ReportServiceImpl(ReportRepository reportRepository) {
		super();
		this.reportRepository = reportRepository;
	}

	@Override
	public List<DeliveryOrderCityDTO> findViewDeliveryOrderGroupByCity(String userId) {
		
		return reportRepository.findViewDeliveryOrderGroupByCity(userId);
	}

}
