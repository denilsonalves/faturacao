package com.fatura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatura.models.Cliente;
import com.fatura.repository.ClienteRepositoty;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepositoty clienteRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
