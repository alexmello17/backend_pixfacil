package com.pix.api.pixfacil.dto.pixfacil;

import io.swagger.annotations.ApiModelProperty;

public class LoginDTO {

    @ApiModelProperty(value = "usuario de autenticaçao")
	private String user;

    @ApiModelProperty(value = "senha de autenticação")
	private String pass;
	
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
	
}
