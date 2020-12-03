package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TXID database table.
 * 
 */
@Entity
@NamedQuery(name="Txid.findAll", query="SELECT t FROM Txid t")
public class Txid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String txid;

	//bi-directional many-to-one association to Venda
	@OneToMany(mappedBy="txidBean")
	private List<Venda> vendas;

	public Txid() {
	}
	
	public Txid(String txid) {
		this.txid = txid;
	}

	public String getTxid() {
		return this.txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Venda addVenda(Venda venda) {
		getVendas().add(venda);
		venda.setTxidBean(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setTxidBean(null);

		return venda;
	}

}