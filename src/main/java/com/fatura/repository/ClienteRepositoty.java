package com.fatura.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatura.models.Cliente;

@Repository
public interface ClienteRepositoty extends CrudRepository<Cliente, Long> {

}
