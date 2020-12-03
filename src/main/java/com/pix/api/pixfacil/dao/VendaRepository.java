package com.pix.api.pixfacil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pix.api.pixfacil.entity.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {
	
	@Query("SELECT u FROM Venda u WHERE u.usuario.idUser = :idUsuario ORDER BY u.datavenda DESC")
	List<Venda> findVendasByUsuario(@Param("idUsuario") Long idUsuario);
	
}