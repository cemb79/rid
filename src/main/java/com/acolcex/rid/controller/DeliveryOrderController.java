package com.acolcex.rid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.service.DeliveryOrderService;

@RestController
@Validated
@RequestMapping(value = UrlConstants.DELIVERY_ORDER)
public class DeliveryOrderController {
	
	@Autowired
	private DeliveryOrderService doService;

	public ResponseEntity<?> findAll(){
		List<DeliveryOrder> dos = doService.findAll();
		return null;
	}
}
