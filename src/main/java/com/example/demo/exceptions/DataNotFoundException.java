package com.example.demo.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class DataNotFoundException extends DataIntegrityViolationException {

	private static final long serialVersionUID = 5L;

	public DataNotFoundException(String msg) {
		
		super(msg);
		
	}
	
	public DataNotFoundException(String msg, Throwable err) {
		
		super(msg, err);
		
	}

}
