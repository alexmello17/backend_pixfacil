package com.pix.api.pixfacil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pix.api.pixfacil.entity.Loja;

@Repository
public interface LojaRepository extends CrudRepository<Loja, Long> {
	
	@Query("SELECT a FROM Loja a WHERE a.estabelecimento.idestab = :id")
	List<Loja> findByEstabId(@Param("id") long idEstab);
	
}