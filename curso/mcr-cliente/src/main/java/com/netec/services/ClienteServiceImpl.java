package com.netec.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netec.dao.IClienteDAO;
import com.netec.entities.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	IClienteDAO clienteDAO;
	
	@Value("${server.port}")
	private int port;

	@Override
	public Cliente insert(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDAO.save(cliente);
	}

	@Override
	public Cliente findById(int id) {
		// TODO Auto-generated method stub
		return clienteDAO.findById(id)
				.stream()
				.filter(c -> c != null)
				.peek( c -> c.setPort(port))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No hay"));
	}

	@Override
	public void update(Cliente cliente) {
		Stream.of(cliente)
		.filter(c -> clienteDAO.existsById(c.getId()))
		.peek(c -> clienteDAO.save(c))
		.findFirst()
		.orElseThrow(() -> new RuntimeException("No hay cliente"));
	}

	@Override
	public void deleteById(int id) {
		clienteDAO.deleteById(id);
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	public List<Cliente> findByCorreo(String correo) {
		// TODO Auto-generated method stub
		return clienteDAO.buscarPorCorreo(correo)
				.orElseThrow(() -> new RuntimeException("No hay cliente"));
	}

}
