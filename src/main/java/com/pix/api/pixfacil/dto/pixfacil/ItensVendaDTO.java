package com.pix.api.pixfacil.dto.pixfacil;

import java.math.BigDecimal;
import java.util.Base64;

public class ItensVendaDTO {
	
	private BigDecimal descPercentual;

	private BigDecimal descValor;

	private BigDecimal quantidade;

	private Long idProduto;
	
	private String codBarras;

	private String titulo;

	private String descricao;

	private BigDecimal valor;

	private String imgProduto;

	public BigDecimal getDescPercentual() {
		return descPercentual;
	}

	public void setDescPercentual(BigDecimal descPercentual) {
		this.descPercentual = descPercentual;
	}

	public BigDecimal getDescValor() {
		return descValor;
	}

	public void setDescValor(BigDecimal descValor) {
		this.descValor = descValor;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getImgProduto() {
		return imgProduto;
	}

	public void setImgProduto(String imgProduto) {
		this.imgProduto = imgProduto;
	}
		
	public void setImgProduto(byte[] imgProduto) {
		if(imgProduto != null)
			this.imgProduto = Base64.getEncoder().encodeToString(imgProduto);
	}
	
}
