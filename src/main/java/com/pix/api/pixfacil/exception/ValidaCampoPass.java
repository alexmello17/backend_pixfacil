package com.pix.api.pixfacil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Login - campo 'pass' obrigat\u00F3rio")
public class ValidaCampoPass extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}