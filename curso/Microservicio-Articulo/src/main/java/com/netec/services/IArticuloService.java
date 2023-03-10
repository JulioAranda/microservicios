package com.netec.services;

import java.util.List;

import com.netec.entities.Articulo;

public interface IArticuloService {
	Articulo insert(Articulo articulo);
	Articulo findById(int id);
	void update(Articulo articulo);
	void deleteById(int id);
	List<Articulo> findAll();
	List<Articulo> findByMarca(String marca);

}
