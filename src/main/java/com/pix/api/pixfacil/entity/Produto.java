package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the PRODUTO database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idproduto;

	@Column(name="COD_BARRAS")
	private String codBarras;

	private String titulo;

	private String descricao;

	private BigDecimal valor;
	
	@Lob
	@Column(name = "IMG_PRODUTO", columnDefinition = "BLOB")
	private byte[] imgProduto;


	public Produto() {
	}

	public long getIdproduto() {
		return this.idproduto;
	}

	public void setIdproduto(long idproduto) {
		this.idproduto = idproduto;
	}

	public String getCodBarras() {
		return this.codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

//	public List<Estoque> getEstoques() {
//		return this.estoques;
//	}
//
//	public void setEstoques(List<Estoque> estoques) {
//		this.estoques = estoques;
//	}
//
//	public Estoque addEstoque(Estoque estoque) {
//		getEstoques().add(estoque);
//		estoque.setProduto(this);
//
//		return estoque;
//	}
//
//	public Estoque removeEstoque(Estoque estoque) {
//		getEstoques().remove(estoque);
//		estoque.setProduto(null);
//
//		return estoque;
//	}

//	public List<ItensVenda> getItensVendas() {
//		return this.itensVendas;
//	}
//
//	public void setItensVendas(List<ItensVenda> itensVendas) {
//		this.itensVendas = itensVendas;
//	}

//	public ItensVenda addItensVenda(ItensVenda itensVenda) {
//		getItensVendas().add(itensVenda);
//		itensVenda.setProduto(this);
//
//		return itensVenda;
//	}
//
//	public ItensVenda removeItensVenda(ItensVenda itensVenda) {
//		getItensVendas().remove(itensVenda);
//		itensVenda.setProduto(null);
//
//		return itensVenda;
//	}

	public byte[] getImgProduto() {
		return imgProduto;
	}

	public void setImgProduto(byte[] imgProduto) {
		this.imgProduto = imgProduto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}