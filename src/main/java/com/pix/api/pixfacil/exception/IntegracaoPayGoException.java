package com.pix.api.pixfacil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Erro ao integrar com API PayGo.")
public class IntegracaoPayGoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}