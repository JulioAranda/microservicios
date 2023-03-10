package com.netec.services;

import java.util.List;

import com.netec.entities.Articulo;

public interface ICarritoService {
	boolean insert(int id);
	List<Articulo> showAll();
	double total();

}
