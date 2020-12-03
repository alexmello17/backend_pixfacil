package com.pix.api.pixfacil.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pix.api.pixfacil.entity.Estoque;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Long> {
	
	@Query("SELECT u FROM Estoque u WHERE u.produto.idproduto = :idProduto AND u.loja.idloja = :idLoja")
	Estoque findeByIdProdutoLoja(@Param("idProduto") Long idProduto, @Param("idLoja") Long idLoja);
	
}