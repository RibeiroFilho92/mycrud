package com.example.demo.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3L;

	public ObjectNotFoundException(String msg) {
		
		super(msg);
		
	}
	
	public ObjectNotFoundException(String msg, Throwable err) {
		
		super(msg, err);
		
	}

}
