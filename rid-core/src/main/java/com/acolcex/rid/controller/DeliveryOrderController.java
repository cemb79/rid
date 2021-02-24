package com.acolcex.rid.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acolcex.rid.controller.util.ApiResponse;
import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.DeliveryOrderHistory;
import com.acolcex.rid.model.DeliveryOrderManagement;
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
	public ApiResponse findAll(){
		logger.info("Finding all Delivery Orders");
		Set<DeliveryOrder> dos = deliveryOrderService.findAll();
		logger.info("Number of delivery orders: {}", dos.size());
		ApiResponse response = ApiResponse.successResponse(dos);
		return response;
	}
	
	@RequestMapping(value = WebPaths.DELIVERY_ORDER_FIND_BY_NUM_DO, method = {RequestMethod.GET})
    @ResponseBody
	public ApiResponse findById(@PathVariable String numDO) {
		logger.info("Finding Delivery Orders by num DO {}", numDO);
		ApiResponse response = null;
		try {
			DeliveryOrder order = deliveryOrderService.findById(numDO);
			response = ApiResponse.successResponse(order);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			response = ApiResponse.errorResponse(e.getMessage());
		}
		
		return response;
	}
	
	@RequestMapping(value = WebPaths.DELIVERY_ORDER_FIND_USER, method = {RequestMethod.GET})
    @ResponseBody
	public ApiResponse findByUserId(@PathVariable String userId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
		logger.info("Finding Delivery Orders by userId {}", userId);
		Pageable paging = PageRequest.of(page, size);
		ApiResponse response = null;
		try {
			Page<DeliveryOrder> dos = deliveryOrderService.findByUserId(userId, paging);
			response = ApiResponse.successResponse(dos);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			response = ApiResponse.errorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = WebPaths.DELIVERY_ORDER_MANAGEMENT, method = {RequestMethod.GET})
    @ResponseBody
	public ApiResponse findDOManagementByDOId(@PathVariable String numDO) {
		logger.info("Finding Delivery Order Management by num DO {}", numDO);
		ApiResponse response = null;
		try {
			DeliveryOrderManagement doMan = deliveryOrderService.findDOManagementByDOId(numDO);
			response = ApiResponse.successResponse(doMan);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			response = ApiResponse.errorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = WebPaths.DELIVERY_ORDER_HISTORY, method = {RequestMethod.GET})
    @ResponseBody
	public ApiResponse findDOHistoryByDOId(@PathVariable String numDO) {
		logger.info("Finding Delivery Order History by num DO {}", numDO);
		ApiResponse response = null;
		try {
			Set<DeliveryOrderHistory> listHistory = deliveryOrderService.findDOHistoryByDOId(numDO);
			response = ApiResponse.successResponse(listHistory);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			response = ApiResponse.errorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = WebPaths.DELIVERY_ORDER_FIND_CLIENT_CRITERIA, method = {RequestMethod.GET})
    @ResponseBody
	public ApiResponse findDOByCriteria(@PathVariable String clientId, @RequestParam(name = "criteria") String criteria, @RequestParam(defaultValue = "50") int size) {
		logger.info("Finding Delivery Order by clientId {} and criteria '{}'", clientId, criteria);
		Pageable paging = PageRequest.of(0, size);
		ApiResponse response = null;
		try {
			Page<DeliveryOrder> listDO = deliveryOrderService.findDOByCriteria(clientId, criteria, paging);
			response = ApiResponse.successResponse(listDO);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response = ApiResponse.errorResponse(e.getMessage());
		}
		return response;
	}
}
