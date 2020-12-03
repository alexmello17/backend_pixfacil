package com.pix.api.pixfacil.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pix.api.pixfacil.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.username = :user and u.password = :pass")
	Usuario findByUserNamePass(@Param("user") String user, @Param("pass") String pass);
	
}