package com.acolcex.rid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acolcex.rid.controller.util.ApiResponse;
import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.dto.DeliveryOrderCityDTO;
import com.acolcex.rid.service.ReportService;

@Controller
public class ReportController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	
	private ReportService reportService;
	
	public ReportController(ReportService reportService) {
		super();
		this.reportService = reportService;
	}

	@RequestMapping(value = WebPaths.REPORT_DO_SUMMARY_BY_PORT, method = {RequestMethod.GET})
    @ResponseBody
	public ResponseEntity<?> findByUserId(@PathVariable String userId) {
		logger.info("Entering report of Delivery Orders group by city and userId: {}", userId);
		List<DeliveryOrderCityDTO> dos = reportService.findViewDeliveryOrderGroupByCity(userId);
		HashMap<String, Object> map = new HashMap<>();
		map.put("data", dos);
		return new ResponseEntity<>(map, getHeaders(), HttpStatus.OK);
	}
	
	private MultiValueMap<String, String> getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept-Charset", "iso-8859-1");
		return headers;
	}
	
	@GetMapping(WebPaths.DELIVERY_ORDER_FIND_CLIENT_PORT)
    @ResponseBody
	public ApiResponse findDoByClientIdAndPortId(@PathVariable String clientId, @PathVariable String portId, 
												@RequestParam(defaultValue = "0") int page,
	        									@RequestParam(defaultValue = "25") int size) {
		logger.info("Finding DOs by clientId {} and port {}", clientId, portId);
		ApiResponse response = null;
		try {
			Pageable paging = PageRequest.of(page, size);
			Page<DeliveryOrder> pageDO = reportService.findDeliveryOrderByPort(portId, clientId, paging);
			Map<String, Object> map = new HashMap<>();
			map.put("content", pageDO.getContent());
			map.put("totalElements", pageDO.getTotalElements());
			map.put("totalPages", pageDO.getTotalPages());
			map.put("currentPage", pageDO.getNumber());
			return ApiResponse.successResponse(map);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response = ApiResponse.errorResponse(e.getMessage());
		}
		
		return response;
	}
}
