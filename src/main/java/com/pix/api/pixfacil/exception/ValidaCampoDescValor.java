package com.pix.api.pixfacil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Incluir Venda - campo 'descValor' obrigat\u00F3rio")
public class ValidaCampoDescValor extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}