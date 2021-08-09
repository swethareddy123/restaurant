package com.resto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestoException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public RestoException(String message) {
		super(message);
	}
}
