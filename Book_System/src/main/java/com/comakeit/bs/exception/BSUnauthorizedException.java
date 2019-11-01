package com.comakeit.bs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class BSUnauthorizedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public BSUnauthorizedException(String exception) {
		super(exception);
	}
}
