package com.acolcex.rid.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
