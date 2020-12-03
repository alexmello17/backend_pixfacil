package com.pix.api.pixfacil.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pix.api.pixfacil.entity.Txid;

@Repository
public interface TxIdRepository extends CrudRepository<Txid, String> {
	
}