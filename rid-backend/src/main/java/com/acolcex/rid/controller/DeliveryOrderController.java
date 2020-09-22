package com.acolcex.rid.controller;

import java.util.HashMap;
import java.util.Set;

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

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.service.DeliveryOrderService;
import com.acolcex.rid.service.ServiceException;

@Controller
public class DeliveryOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeliveryOrderController.class);
	
	private DeliveryOrderService deliveryOrderService;
	
	public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
		this.deliveryOrderService = deliveryOrderService;
	}

	@RequestMapping(value = WebPaths.DELIVERY_ORDER_FIND_ALL, method = RequestMethod.GET)
    @ResponseBody
	public ResponseEntity<?> findAll(){
		logger.info("Finding all Delivery Orders");
		Set<DeliveryOrder> dos = deliveryOrderService.findAll();
		logger.info("Number of delivery orders: {}", dos.size());
		HashMap<String, Object> body = new HashMap<>();
		body.put("data", dos);
		ResponseEntity<?> response = new ResponseEntity<>(body, getHeaders(), HttpStatus.OK);
		return response;
	}
	
	private MultiValueMap<String, String> getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		return headers;
	}

	@RequestMapping(value = WebPaths.DELIVERY_ORDER_FIND, method = {RequestMethod.GET})
    @ResponseBody
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		logger.info("Finding Delivery Orders by id {}", id);
		ResponseEntity<?> response = null;
		try {
			DeliveryOrder order = deliveryOrderService.findById(id);
			HashMap<String, Object> map = new HashMap<>();
			map.put("data", order);
			response = new ResponseEntity<>(map, getHeaders(), HttpStatus.OK);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			response = new ResponseEntity<>(getHeaders(), HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@RequestMapping(value = WebPaths.DELIVERY_ORDER_FIND_USER, method = {RequestMethod.GET})
    @ResponseBody
	public ResponseEntity<?> findByUserId(@PathVariable String userId) {
		logger.info("Finding Delivery Orders by userId {}", userId);
		Set<DeliveryOrder> dos = deliveryOrderService.findByUserId(userId);
		HashMap<String, Object> map = new HashMap<>();
		map.put("data", dos);
		return new ResponseEntity<>(map, getHeaders(), HttpStatus.OK);
	}
}
