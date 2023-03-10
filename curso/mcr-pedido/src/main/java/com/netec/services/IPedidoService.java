package com.netec.services;

import java.util.List;

import com.netec.entities.Pedido;

public interface IPedidoService {
	
	Pedido insert(Pedido pedido);
	Pedido findById(int id);
	void update(Pedido articulo);
	void deleteById(int id);
	List<Pedido> findAll();

}
