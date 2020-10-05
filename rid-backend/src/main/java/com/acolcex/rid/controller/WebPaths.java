package com.acolcex.rid.controller;

public final class WebPaths {

	public static final String LOGIN = "/login";
	public static final String DELIVERY_ORDER = "deliveryOrders";
	public static final String DELIVERY_ORDER_FIND_ALL = "/deliveryOrders/findAll";
	public static final String DELIVERY_ORDER_FIND = "/deliveryOrders/find/{id}";
	public static final String DELIVERY_ORDER_FIND_CLIENT_PORT = "/deliveryOrders/find/{clientId}/{portId}";
	public static final String DELIVERY_ORDER_FIND_USER = "/deliveryOrders/find/user/{userId}";
	
	public static final String REPORT_DO_SUMMARY_BY_PORT = "report/deliveryOrder/summary/port/{userId}";
	public static final String USER_FIND = "/user/{id}";
}
