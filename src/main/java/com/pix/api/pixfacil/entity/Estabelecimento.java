package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the ESTABELECIMENTO database table.
 * 
 */
@Entity
@NamedQuery(name="Estabelecimento.findAll", query="SELECT e FROM Estabelecimento e")
public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idestab;

	@Column(name="CATEG_COMERCIO")
	private BigDecimal categComercio;

	@Column(name="CHAVE_PIX")
	private String chavePix;

	private String cidade;

	private String cnpj;

	@Column(name="COD_MOEDA")
	private String codMoeda;

	@Column(name="COD_PAIS")
	private String codPais;

	@Column(name="NOM_COMERCIO")
	private String nomComercio;

	@Column(name="TIPO_CHAVE_PIX")
	private String tipoChavePix;

	private String url;

	//bi-directional many-to-one association to Loja
//	@OneToMany(mappedBy="estabelecimento")
//	private List<Loja> lojas;
//
//	//bi-directional many-to-one association to Produto
//	@OneToMany(mappedBy="estabelecimento")
//	private List<Produto> produtos;

	//bi-directional many-to-one association to Usuario
//	@OneToMany(mappedBy="estabelecimento")
//	private List<Usuario> usuarios;

	public Estabelecimento() {
	}

	public long getIdestab() {
		return this.idestab;
	}

	public void setIdestab(long idestab) {
		this.idestab = idestab;
	}

	public BigDecimal getCategComercio() {
		return this.categComercio;
	}

	public void setCategComercio(BigDecimal categComercio) {
		this.categComercio = categComercio;
	}

	public String getChavePix() {
		return this.chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodMoeda() {
		return this.codMoeda;
	}

	public void setCodMoeda(String codMoeda) {
		this.codMoeda = codMoeda;
	}

	public String getCodPais() {
		return this.codPais;
	}

	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}

	public String getNomComercio() {
		return this.nomComercio;
	}

	public void setNomComercio(String nomComercio) {
		this.nomComercio = nomComercio;
	}

	public String getTipoChavePix() {
		return this.tipoChavePix;
	}

	public void setTipoChavePix(String tipoChavePix) {
		this.tipoChavePix = tipoChavePix;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	public List<Loja> getLojas() {
//		return this.lojas;
//	}
//
//	public void setLojas(List<Loja> lojas) {
//		this.lojas = lojas;
//	}

//	public Loja addLoja(Loja loja) {
//		getLojas().add(loja);
//		loja.setEstabelecimento(this);
//
//		return loja;
//	}
//
//	public Loja removeLoja(Loja loja) {
//		getLojas().remove(loja);
//		loja.setEstabelecimento(null);
//
//		return loja;
//	}

//	public List<Produto> getProdutos() {
//		return this.produtos;
//	}
//
//	public void setProdutos(List<Produto> produtos) {
//		this.produtos = produtos;
//	}

//	public Produto addProduto(Produto produto) {
//		getProdutos().add(produto);
//		produto.setEstabelecimento(this);
//
//		return produto;
//	}
//
//	public Produto removeProduto(Produto produto) {
//		getProdutos().remove(produto);
//		produto.setEstabelecimento(null);
//
//		return produto;
//	}

//	public List<Usuario> getUsuarios() {
//		return this.usuarios;
//	}
//
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}
//
//	public Usuario addUsuario(Usuario usuario) {
//		getUsuarios().add(usuario);
//		usuario.setEstabelecimento(this);
//
//		return usuario;
//	}
//
//	public Usuario removeUsuario(Usuario usuario) {
//		getUsuarios().remove(usuario);
//		usuario.setEstabelecimento(null);
//
//		return usuario;
//	}

}