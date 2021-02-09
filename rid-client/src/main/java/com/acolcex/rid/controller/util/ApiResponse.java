package com.acolcex.rid.controller.util;

public class ApiResponse {

	private boolean success;

	private String message;

	private Object data;

	public static ApiResponse successResponse(Object data) {
		ApiResponse map = new ApiResponse();
		map.setSuccess(true);
		map.setData(data);
		return map;
	}

	public static ApiResponse errorResponse(String message) {
		ApiResponse map = new ApiResponse();
		map.setSuccess(false);
		map.setMessage(message);
		return map;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
