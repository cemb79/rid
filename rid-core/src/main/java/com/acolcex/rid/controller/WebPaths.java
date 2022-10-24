package com.acolcex.rid.controller;

public final class WebPaths {

	public static final String LOGIN = "/login";
	public static final String CUSTOMER_FIND_ALL = "customers";
	public static final String DELIVERY_ORDER = "deliveryOrders";
	public static final String DELIVERY_ORDER_FIND_ALL = "/deliveryOrders/findAll";
	public static final String DELIVERY_ORDER_FIND_BY_NUM_DO = "/deliveryOrders/find/{numDO}";
	public static final String DELIVERY_ORDER_FIND_CLIENT_CRITERIA = "/deliveryOrders/client/{clientId}";
	public static final String DELIVERY_ORDER_FIND_CLIENT_PORT = "/deliveryOrders/find/{clientId}/{portId}";
	public static final String DELIVERY_ORDER_FIND_CLIENT_MONTH = "/deliveryOrders/find/{clientId}/month";
	public static final String DELIVERY_ORDER_FIND_CLIENT_STATUS = "/deliveryOrders/find/{clientId}/status";
	public static final String DELIVERY_ORDER_FIND_USER = "/deliveryOrders/find/user/{userId}";
	public static final String DELIVERY_ORDER_MANAGEMENT = "/deliveryOrders/management/{numDO}";
	public static final String DELIVERY_ORDER_HISTORY = "/deliveryOrders/history/{numDO}";
	public static final String REPORT_DO_SUMMARY_BY_PORT = "report/deliveryOrder/summary/port/{userId}";
	public static final String USER_FIND = "/user/{id}";
}
