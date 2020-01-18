package com.fatura.service;

import java.util.List;

import com.fatura.models.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
}
