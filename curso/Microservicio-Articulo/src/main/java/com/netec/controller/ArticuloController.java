package com.netec.controller;

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

import com.netec.entities.Articulo;
import com.netec.services.IArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
	
	@Autowired
	private IArticuloService articuloService;
	
	@PostMapping
	public Articulo insert(@RequestBody Articulo articulo) {
		return articuloService.insert(articulo);
	}
	
	@GetMapping("/{id}")
	public Articulo findById(@PathVariable int id) {
		return articuloService.findById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Articulo articulo) {
		articuloService.update(articulo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		articuloService.deleteById(id);
	}
	
	@GetMapping
	public List<Articulo> findAll() {
		return articuloService.findAll();
	}
	
	@GetMapping("/marca/{marca}")
	public List<Articulo> findByMarca(@PathVariable String marca) {
		return articuloService.findByMarca(marca);
	}

}
