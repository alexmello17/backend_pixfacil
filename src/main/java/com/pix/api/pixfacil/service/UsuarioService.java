package com.pix.api.pixfacil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pix.api.pixfacil.dao.UsuarioRepository;
import com.pix.api.pixfacil.dto.pixfacil.LoginDTO;
import com.pix.api.pixfacil.dto.pixfacil.UsuarioDTO;
import com.pix.api.pixfacil.entity.Usuario;
import com.pix.api.pixfacil.exception.UsuarioNaoEncontradoException;
import com.pix.api.pixfacil.exception.ValidaCampoPass;
import com.pix.api.pixfacil.exception.ValidaCampoUser;

@Service
public class UsuarioService {
	
	@Autowired 
	private UsuarioRepository userRepo;
	
	public UsuarioDTO login(LoginDTO dto) {
		camposValidos(dto);			
		return parseDTO(userRepo.findByUserNamePass(dto.getUser(), dto.getPass()));
	}
	
	public List<UsuarioDTO> findAll(){
		return parseDTO(userRepo.findAll());
	}
	
	private List<UsuarioDTO> parseDTO(Iterable<Usuario> usuarios){
		List<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();
		UsuarioDTO dto;
		for(Usuario u : usuarios) {
		  	if(u == null) {
	    		throw new UsuarioNaoEncontradoException();
	    	}
			dto = new UsuarioDTO(u.getIdUser(), u.getUsername(), u.getPassword(), u.getUsertype(), u.getEstabelecimento(), u.getLoja());
			dtos.add(dto);
		}
		return dtos;
	}

	private UsuarioDTO parseDTO(Usuario u){
	  	if(u == null) {
    		throw new UsuarioNaoEncontradoException();
    	}
		return new UsuarioDTO(u.getIdUser(), u.getUsername(), u.getPassword(), u.getUsertype(), u.getEstabelecimento(), u.getLoja()==null ? 0 : u.getLoja());
	}
	
	private void camposValidos(LoginDTO ldto) {
		if(ldto.getUser() == null)
			throw new ValidaCampoUser();
		
		if(ldto.getPass() == null)
			throw new ValidaCampoPass();

	}
	
}
