package com.pix.api.pixfacil.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pix.api.pixfacil.dto.pixfacil.RetornoVendaDTO;
import com.pix.api.pixfacil.dto.pixfacil.VendaDTO;

@Service
public interface IVenda {
	RetornoVendaDTO incluirVenda(VendaDTO o);
	
	List<VendaDTO> buscarVendas(Long idUsuario);	
}
