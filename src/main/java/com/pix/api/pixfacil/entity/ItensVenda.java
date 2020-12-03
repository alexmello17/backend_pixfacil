package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the ITENS_VENDA database table.
 * 
 */
@Entity
@Table(name="ITENS_VENDA")
@NamedQuery(name="ItensVenda.findAll", query="SELECT i FROM ItensVenda i")
public class ItensVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iditem;

	@Column(name="DESC_PERCENTUAL")
	private BigDecimal descPercentual;

	@Column(name="DESC_VALOR")
	private BigDecimal descValor;

	private BigDecimal quantidade;

	@Column(name="VALOR_ITEM")
	private BigDecimal valorItem;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="IDPRODUTO")
	private Produto produto;

	//bi-directional many-to-one association to Venda
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="IDVENDA")
	private Venda venda;

	public ItensVenda() {
	}

	public Long getIditem() {
		return this.iditem;
	}

	public void setIditem(Long iditem) {
		this.iditem = iditem;
	}

	public BigDecimal getDescPercentual() {
		return this.descPercentual;
	}

	public void setDescPercentual(BigDecimal descPercentual) {
		this.descPercentual = descPercentual;
	}

	public BigDecimal getDescValor() {
		return this.descValor;
	}

	public void setDescValor(BigDecimal descValor) {
		this.descValor = descValor;
	}

	public BigDecimal getValorItem() {
		return this.valorItem;
	}

	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return this.venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

}