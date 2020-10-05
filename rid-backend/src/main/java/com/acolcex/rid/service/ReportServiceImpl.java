package com.acolcex.rid.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;
import com.acolcex.rid.repository.DeliveryOrderRepository;
import com.acolcex.rid.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	private ReportRepository reportRepository;
	private DeliveryOrderRepository doRepository;
	
	public ReportServiceImpl(ReportRepository reportRepository, DeliveryOrderRepository doRepository) {
		super();
		this.reportRepository = reportRepository;
		this.doRepository = doRepository;
	}

	@Override
	public List<DeliveryOrderCityDTO> findViewDeliveryOrderGroupByCity(String userId) {
		
		return reportRepository.findViewDeliveryOrderGroupByCity(userId);
	}

	@Override
	public Page<DeliveryOrder> findDeliveryOrderByPort(String port, String clientId, Pageable pageable) {
		Page<DeliveryOrder> page = doRepository.findByPortIdAndClientId(port, clientId, pageable);
		logger.debug("Retrieving page {} of ", page.getNumber(), page.getTotalPages());
		return page;
	}
}
