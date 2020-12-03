package com.pix.api.pixfacil.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pix.api.pixfacil.service.IVenda;
import com.pix.api.pixfacil.service.VendaPayGoImpl;

@Configuration
public class BeanConfig {
	
	private static final String PAYGO = "paygo";
		
	@Value("${integrador.pix}")
	private String integradroPix;

	@Bean
	public IVenda getIVenda() {
		if (integradroPix.equals(PAYGO))
			return new VendaPayGoImpl();
		else 
			return null;
	}

}
