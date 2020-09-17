package com.acolcex.rid.bootstrap;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.acolcex.rid.model.DeliveryOrder;
import com.acolcex.rid.model.Office;
import com.acolcex.rid.repository.DeliveryOrderRepository;

//@Component
public class BootStrapData implements CommandLineRunner {
	
	@Autowired
	private DeliveryOrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		Office office = new Office();
		office.setCodSucursal("BOG");
		deliveryOrder.setOffice(office);
		deliveryOrder.setDateStamp(new Date());
		DeliveryOrder resp = orderRepository.save(deliveryOrder);
		System.out.println(resp.getRegDO());
	}

}
