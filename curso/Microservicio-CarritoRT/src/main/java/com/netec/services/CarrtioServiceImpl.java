package com.netec.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netec.entities.Articulo;
import com.netec.entities.Carrito;

@Service
public class CarrtioServiceImpl implements ICarritoService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Carrito carrito;

	@Override
	public boolean insert(int id) {
		Map<String,String> mapaArticulo = new HashMap<>();
		mapaArticulo.put("id", String.valueOf(id));
		String url = "http://localhost:9091/articulo/{id}";
		
		try {
			Articulo articulo = restTemplate.getForObject(url, Articulo.class, mapaArticulo);
			carrito.getArticulos().add(articulo);
			return true;
			
		} catch(Exception e) {
			System.out.println("Error en el insert" + e);	
		}
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		Articulo articulo = carrito.getArticulos()
		.stream()
		.filter(a -> a.getId() == id)
		.findFirst()
		.orElse(null);
		
		return this.carrito.getArticulos().remove(articulo);
	}

	@Override
	public Articulo searchByName(String name) {
		return carrito.getArticulos()
		.stream()
		.filter(a -> a.getNombre().equals(name))
		.findFirst()
		.orElse(null);
	}

	@Override
	public List<Articulo> showAll() {
		return carrito.getArticulos();
	}

	@Override
	public double total() {
		return carrito.getArticulos()
				.stream()
				.mapToDouble(a -> a.getPrecio())
				.sum();
	}

}
