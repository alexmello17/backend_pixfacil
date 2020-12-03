package com.pix.api.pixfacil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Erro ao realizar inclus\\u00E3o de nova venda.")
public class VendaNaoEfetuadaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}