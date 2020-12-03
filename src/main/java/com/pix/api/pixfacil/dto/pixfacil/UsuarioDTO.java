package com.pix.api.pixfacil.dto.pixfacil;

public class UsuarioDTO {

	private long idUsuario;
	private String user;
	private String pass;
	private String profile;
	private long idEstab;
	private long idLoja;
	
	public UsuarioDTO(long idUsuario, String user, String pass, String profile, long idEstab, long idLoja) {
		super();
		this.user = user;
		this.pass = pass;
		this.profile = profile;
		this.idEstab = idEstab;
		this.idLoja = idLoja;
		this.idUsuario = idUsuario;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	public long getIdEstab() {
		return idEstab;
	}

	public void setIdEstab(long idEstab) {
		this.idEstab = idEstab;
	}

	public long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(long idLoja) {
		this.idLoja = idLoja;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
