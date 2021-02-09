package com.acolcex.rid.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 7422776731513490593L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
