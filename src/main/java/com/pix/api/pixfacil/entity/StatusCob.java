package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATUS_COB database table.
 * 
 */
@Entity
@Table(name="STATUS_COB")
@NamedQuery(name="StatusCob.findAll", query="SELECT s FROM StatusCob s")
public class StatusCob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idstatus;

	private String descricao;

	//bi-directional many-to-one association to Venda
	@OneToMany(mappedBy="statusCob")
	private List<Venda> vendas;

	public StatusCob() {
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
		venda.setStatusCob(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setStatusCob(null);

		return venda;
	}

}