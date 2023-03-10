package com.netec.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Carrito {
	
	private List<Articulo> articulos = new ArrayList<>();
	
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

}
