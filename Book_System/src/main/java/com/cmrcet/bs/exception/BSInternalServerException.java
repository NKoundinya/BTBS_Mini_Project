package com.cmrcet.bs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BSInternalServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BSInternalServerException() {
	}

	public BSInternalServerException(String exception) {
		super(exception);
	}
}
