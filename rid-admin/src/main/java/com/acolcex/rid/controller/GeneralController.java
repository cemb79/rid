package com.acolcex.rid.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acolcex.rid.controller.util.ApiResponse;
import com.acolcex.rid.model.Customer;
import com.acolcex.rid.service.CustomerService;

@Controller
public class GeneralController {

	private static final Logger logger = LoggerFactory.getLogger(GeneralController.class);
	
	private CustomerService customerService;
	
	public GeneralController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(value = WebPaths.CUSTOMER_FIND_ALL, method = RequestMethod.GET)
    @ResponseBody
	public ApiResponse getCustomerList() {
		logger.info("Fetching all customer list");
		List<Customer> customerList = customerService.findAllCustomers();
		return ApiResponse.successResponse(customerList);
	}
}
