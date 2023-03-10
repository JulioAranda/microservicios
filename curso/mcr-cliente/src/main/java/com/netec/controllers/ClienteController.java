package com.netec.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netec.entities.Cliente;
import com.netec.services.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping
	public Cliente insert(@RequestBody Cliente cliente) {
		return clienteService.insert(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente findById(@PathVariable int id) {
		return clienteService.findById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Cliente cliente) {
		clienteService.update(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		clienteService.deleteById(id);
	}
	
	@GetMapping
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}
	
	@GetMapping("/correo/{correo}")
	public List<Cliente> findByCorreo(@PathVariable String correo) {
		return clienteService.findByCorreo(correo);
	}


}
