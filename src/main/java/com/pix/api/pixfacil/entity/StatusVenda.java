package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATUS_VENDA database table.
 * 
 */
@Entity
@Table(name="STATUS_VENDA")
@NamedQuery(name="StatusVenda.findAll", query="SELECT s FROM StatusVenda s")
public class StatusVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idstatus;

	private String descricao;

	//bi-directional many-to-one association to Venda
	@OneToMany(mappedBy="statusVenda")
	private List<Venda> vendas;

	public StatusVenda() {
	}

	public long getIdstatus() {
		return this.idstatus;
	}

	public void setIdstatus(long idstatus) {
		this.idstatus = idstatus;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Venda addVenda(Venda venda) {
		getVendas().add(venda);
		venda.setStatusVenda(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setStatusVenda(null);

		return venda;
	}

}