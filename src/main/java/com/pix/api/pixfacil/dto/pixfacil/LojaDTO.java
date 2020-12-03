package com.pix.api.pixfacil.dto.pixfacil;

public class LojaDTO {
	
	private long idloja;
	private String endereco;
	private String nome;
	
	public LojaDTO(long idloja, String endereco, String nome) {
		this.idloja = idloja;
		this.endereco = endereco;
		this.nome = nome;
	}
	
	public long getIdloja() {
		return idloja;
	}
	public void setIdloja(long idloja) {
		this.idloja = idloja;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
