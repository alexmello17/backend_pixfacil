package com.pix.api.pixfacil.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -1633920879707257142L;

	@Id
	@Column(name = "ID_USER")
	private long idUser;

	private String password;

	private String username;

	private String usertype;

//	bi-directional many-to-one association to Estabelecimento
	@Column(name = "ID_ESTAB")
	private long estabelecimento;

	// bi-directional many-to-one association to Loja
	@Column(name = "ID_LOJA", nullable = true)
	private Long loja;

//	// bi-directional many-to-one association to Venda
//	@OneToMany(mappedBy = "usuario")
//	private List<Venda> vendas;

	public Usuario() {
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public long getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(long estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Long getLoja() {
		return loja;
	}

	public void setLoja(Long loja) {
		this.loja = loja;
	}

}