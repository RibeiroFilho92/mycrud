package com.example.demo.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors extends StandardError {

	private static final long serialVersionUID = 7L;
	
	private List<FieldMessage> list = new ArrayList<> ();

	public ValidationErrors(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
	}

	public List<FieldMessage> getErrors() {
		return list;
	}

	public void addError(String field, String msg) {
		list.add(new FieldMessage(field, msg));
	}

}
