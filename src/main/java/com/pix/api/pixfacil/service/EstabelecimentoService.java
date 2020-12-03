package com.pix.api.pixfacil.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pix.api.pixfacil.dao.EstabelecimentoRepository;
import com.pix.api.pixfacil.entity.Estabelecimento;
import com.pix.api.pixfacil.exception.EstabelecimentoNotFoundException;
import com.pix.api.pixfacil.exception.ValidaCampoIdEstabelecimento;

@Service
public class EstabelecimentoService {
	
	@Autowired 
	private EstabelecimentoRepository estabRepo;
	
	public Estabelecimento findById(long idEstab) {
		if(idEstab == 0L) {
			throw new ValidaCampoIdEstabelecimento();
		}
		
		Estabelecimento estab = null;
		try {
			estab = estabRepo.findById(idEstab).get();
		}catch (NoSuchElementException e) {
			throw new EstabelecimentoNotFoundException();
		}
		
    	return estab;
	}

}
