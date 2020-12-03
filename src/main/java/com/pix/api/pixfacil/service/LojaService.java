package com.pix.api.pixfacil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pix.api.pixfacil.dao.LojaRepository;
import com.pix.api.pixfacil.dto.pixfacil.LojaDTO;
import com.pix.api.pixfacil.entity.Loja;
import com.pix.api.pixfacil.exception.ProdutoNotFoundException;

@Service
public class LojaService {
	
	@Autowired 
	private LojaRepository lojaRepo;
	
	public List<LojaDTO> findLojasEstabelecimento(long idEstab) {
		return parseDTO(lojaRepo.findByEstabId(idEstab));
	}
	
	public List<LojaDTO> parseDTO(Iterable<Loja> lojas){
		List<LojaDTO> dtos = new ArrayList<LojaDTO>();
		LojaDTO dto;
		
		if(lojas == null || !lojas.iterator().hasNext()) {
			throw new ProdutoNotFoundException();
		}
	
		for(Loja u : lojas) {
			dto = new LojaDTO(u.getIdloja(), u.getEndereco(), u.getNome());
			dtos.add(dto);
		}
		return dtos;
	}

}
