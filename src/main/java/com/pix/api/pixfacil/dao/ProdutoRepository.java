package com.pix.api.pixfacil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pix.api.pixfacil.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	@Query("SELECT a, e.quantidade FROM Produto a, Estoque e WHERE a.codBarras = :codBarras AND e.loja.idloja = :idLoja AND a.idproduto = e.produto.idproduto")
	Object[] findByCodBar(@Param("codBarras") String codBarras, @Param("idLoja") Long idLoja);
	
	@Query("SELECT a, e.quantidade FROM Produto a, Estoque e WHERE LOWER(a.titulo) LIKE CONCAT('%',:desc,'%') AND e.loja.idloja = :idLoja AND a.idproduto = e.produto.idproduto")
	List<Object[]> findByDesc(@Param("desc") String desc, @Param("idLoja") Long idLoja);
	
}