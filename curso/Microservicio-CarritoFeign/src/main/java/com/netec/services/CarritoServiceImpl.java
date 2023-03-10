package com.netec.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.netec.entities.Articulo;
import com.netec.entities.Carrito;
import com.netec.feigns.IArticuloFeign;

@Service
public class CarritoServiceImpl implements ICarritoService {
	
	@Autowired
	private Carrito carrito;
	
	@Autowired
	private IArticuloFeign feign;
	
	@Autowired
	private CircuitBreakerFactory cb;
	
	private final Logger logger = LoggerFactory.getLogger(CarritoServiceImpl.class);
	
	@Override
	public boolean insert(int id) {
		return cb.create("circuito1").run(() -> {
		try {
			
			Articulo articulo = feign.findById(id);
			carrito.getArticulos().add(articulo);
			return true;
			
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
		
		return false;}, i -> caminoSeguro(id));
	}
	
	private boolean caminoSeguro(int id) {
		logger.info("Ejecutando camino seguro.");
		return false;
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
