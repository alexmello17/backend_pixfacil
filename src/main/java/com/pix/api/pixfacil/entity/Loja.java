package com.pix.api.pixfacil.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOJA database table.
 * 
 */
@Entity
@NamedQuery(name="Loja.findAll", query="SELECT l FROM Loja l")
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idloja;

	private String endereco;

	private String nome;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="loja")
	private List<Estoque> estoques;

	//bi-directional many-to-one association to Estabelecimento
	@ManyToOne
	@JoinColumn(name="IDESTAB")
	private Estabelecimento estabelecimento;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="loja")
	private List<Usuario> usuarios;

	public Loja() {
	}

	public long getIdloja() {
		return this.idloja;
	}

	public void setIdloja(long idloja) {
		this.idloja = idloja;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estoque> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque addEstoque(Estoque estoque) {
		getEstoques().add(estoque);
		estoque.setLoja(this);

		return estoque;
	}

	public Estoque removeEstoque(Estoque estoque) {
		getEstoques().remove(estoque);
		estoque.setLoja(null);

		return estoque;
	}

	public Estabelecimento getEstabelecimento() {
		return this.estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}