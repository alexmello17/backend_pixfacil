package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ESTOQUE database table.
 * 
 */
@Entity
@NamedQuery(name="Estoque.findAll", query="SELECT e FROM Estoque e")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idestoque;

	private BigDecimal quantidade;

	//bi-directional many-to-one association to Loja
	@ManyToOne
	@JoinColumn(name="IDLOJA")
	private Loja loja;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="IDPRODUTO")
	private Produto produto;

	public Estoque() {
	}

	public long getIdestoque() {
		return this.idestoque;
	}

	public void setIdestoque(long idestoque) {
		this.idestoque = idestoque;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Loja getLoja() {
		return this.loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}