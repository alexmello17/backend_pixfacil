package com.pix.api.pixfacil.dto.pixfacil;

import java.math.BigDecimal;

public class ProdutoDTO {
	
	private long idproduto;
	private String codBarras;
	private String titulo;
	private String descricao;
	private BigDecimal valor;
	private String base64Img;
	private BigDecimal quantidade;

	public ProdutoDTO(long idproduto, String codBarras, String titulo, String descricao, BigDecimal valor, String base64Img, BigDecimal quantidade) {
		super();
		this.idproduto = idproduto;
		this.codBarras = codBarras;
		this.descricao = descricao;
		this.valor = valor;
		this.base64Img = base64Img;
		this.titulo = titulo;
		this.quantidade = quantidade;
	}
	
	public long getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(long idproduto) {
		this.idproduto = idproduto;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
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
	public String getBase64Img() {
		return base64Img;
	}
	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
}
