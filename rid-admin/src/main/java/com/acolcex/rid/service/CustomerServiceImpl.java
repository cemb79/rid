package com.acolcex.rid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acolcex.rid.model.Customer;
import com.acolcex.rid.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findActiveCustomers();
	}

}
