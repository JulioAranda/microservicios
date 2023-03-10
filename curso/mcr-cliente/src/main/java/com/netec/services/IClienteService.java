package com.netec.services;

import java.util.List;

import com.netec.entities.Cliente;

public interface IClienteService {
	Cliente insert(Cliente cliente);
	Cliente findById(int id);
	void update(Cliente cliente);
	void deleteById(int id);
	List<Cliente> findAll();
	List<Cliente> findByCorreo(String marca);


}
