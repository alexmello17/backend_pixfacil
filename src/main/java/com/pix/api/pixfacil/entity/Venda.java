package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the VENDA database table.
 * 
 */
@Entity
@NamedQuery(name="Venda.findAll", query="SELECT v FROM Venda v")
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idvenda;

	private Date datavenda;

	private BigDecimal expiracao;

	@Column(name="INFO_PAGADOR")
	private String infoPagador;

	@Column(name="VALOR_TOTAL_VENDA")
	private BigDecimal valorTotalVenda;

	//bi-directional many-to-one association to ItensVenda
	@OneToMany(mappedBy="venda", cascade = CascadeType.ALL)
	private List<ItensVenda> itensVendas;

	//bi-directional many-to-one association to StatusCob
	@ManyToOne
	@JoinColumn(name="IDSTATUSCOB")
	private StatusCob statusCob;

	//bi-directional many-to-one association to StatusVenda
	@ManyToOne
	@JoinColumn(name="IDSTATUS")
	private StatusVenda statusVenda;

	//bi-directional many-to-one association to Txid
	@ManyToOne
	@JoinColumn(name="TXID")
	private Txid txidBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="IDVENDEDOR")
	private Usuario usuario;
	
	@Column(name="DESC_VALOR")
	private BigDecimal descValor;

	public Venda() {
	}

	public Long getIdvenda() {
		return this.idvenda;
	}

	public void setIdvenda(Long idvenda) {
		this.idvenda = idvenda;
	}

	public Date getDatavenda() {
		return this.datavenda;
	}

	public void setDatavenda(Date datavenda) {
		this.datavenda = datavenda;
	}

	public BigDecimal getExpiracao() {
		return this.expiracao;
	}

	public void setExpiracao(BigDecimal expiracao) {
		this.expiracao = expiracao;
	}

	public String getInfoPagador() {
		return this.infoPagador;
	}

	public void setInfoPagador(String infoPagador) {
		this.infoPagador = infoPagador;
	}

	public BigDecimal getValorTotalVenda() {
		return this.valorTotalVenda;
	}

	public void setValorTotalVenda(BigDecimal valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	public List<ItensVenda> getItensVendas() {
		return this.itensVendas;
	}

	public void setItensVendas(List<ItensVenda> itensVendas) {
		this.itensVendas = itensVendas;
	}

	public ItensVenda addItensVenda(ItensVenda itensVenda) {
		getItensVendas().add(itensVenda);
		itensVenda.setVenda(this);

		return itensVenda;
	}

	public ItensVenda removeItensVenda(ItensVenda itensVenda) {
		getItensVendas().remove(itensVenda);
		itensVenda.setVenda(null);

		return itensVenda;
	}

	public StatusCob getStatusCob() {
		return this.statusCob;
	}

	public void setStatusCob(StatusCob statusCob) {
		this.statusCob = statusCob;
	}

	public StatusVenda getStatusVenda() {
		return this.statusVenda;
	}

	public void setStatusVenda(StatusVenda statusVenda) {
		this.statusVenda = statusVenda;
	}

	public Txid getTxidBean() {
		return this.txidBean;
	}

	public void setTxidBean(Txid txidBean) {
		this.txidBean = txidBean;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getDescValor() {
		return descValor;
	}

	public void setDescValor(BigDecimal descValor) {
		this.descValor = descValor;
	}

}