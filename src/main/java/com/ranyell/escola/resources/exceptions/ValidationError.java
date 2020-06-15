package com.ranyell.escola.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMenssage> list = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public List<FieldMenssage> getErrors() {
		return list;
	}

	public void addError(String fieldName, String menssage) {
		list.add(new FieldMenssage(fieldName, menssage));
	}
	
	

}
