package com.pix.api.pixfacil.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pix.api.pixfacil.dao.ProdutoRepository;
import com.pix.api.pixfacil.dto.pixfacil.ProdutoDTO;
import com.pix.api.pixfacil.entity.Produto;
import com.pix.api.pixfacil.exception.ProdutoNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepo;

	public ProdutoDTO findById(Long id) {
		try {
			return parseDTO(produtoRepo.findById(id).get());
		}catch (NoSuchElementException e) {
			throw new ProdutoNotFoundException();
		}
	}

	public List<ProdutoDTO> findProdutosByDesc(String desc, Long idLoja) {
		return parseDTO(produtoRepo.findByDesc(desc, idLoja));
	}

	public ProdutoDTO findProdutosByCodbar(String codBarras, Long idLoja) {
		return parseDTO(produtoRepo.findByCodBar(codBarras, idLoja));
	}

	public List<ProdutoDTO> parseDTO(List<Object[]> produtos) {
		List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();
		ProdutoDTO dto;

		if (!produtos.iterator().hasNext()) {
			throw new ProdutoNotFoundException();
		}
		
		for (Object[] u2 : produtos) {
			Produto u = (Produto) u2[0];
			BigDecimal qtd = (BigDecimal) u2[1];
			dto = new ProdutoDTO(u.getIdproduto(), u.getCodBarras(), u.getTitulo(), u.getDescricao(), u.getValor(),
					u.getImgProduto() == null ? null : Base64.getEncoder().encodeToString(u.getImgProduto()), qtd);
			dtos.add(dto);
		}
		return dtos;
	}

	public ProdutoDTO parseDTO(Produto u) {
		if (u == null) {
			throw new ProdutoNotFoundException();
		}

		return new ProdutoDTO(u.getIdproduto(), u.getCodBarras(), u.getTitulo(), u.getDescricao(), u.getValor(),u.getImgProduto() == null ? null : Base64.getEncoder().encodeToString(u.getImgProduto()), null);
	}
	
	public ProdutoDTO parseDTO(Object[] u2) {
		if (u2 == null) {
			throw new ProdutoNotFoundException();
		}
		
		Object[] u3 = (Object[]) u2[0];
		
		if (u3 == null || u3.length == 0) {
			throw new ProdutoNotFoundException();
		}
		
		Produto u = (Produto) u3[0];
		BigDecimal qtd = (BigDecimal) u3[1];

		return new ProdutoDTO(u.getIdproduto(), u.getCodBarras(), u.getTitulo(), u.getDescricao(), u.getValor(), 
				u.getImgProduto() == null ? null : Base64.getEncoder().encodeToString(u.getImgProduto()), qtd);
	}

}
