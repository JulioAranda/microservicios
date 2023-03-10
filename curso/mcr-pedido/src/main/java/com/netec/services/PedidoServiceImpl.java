package com.netec.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netec.dao.IPedidoDAO;
import com.netec.entities.Cliente;
import com.netec.entities.Pedido;
import com.netec.feign.IPedidoFeign;

@Service
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private IPedidoDAO pedidoDAO;
	
	@Autowired
	private IPedidoFeign pedidoFeign;
	
	@Value("${server.port}")
	private int port;

	@Override
	public Pedido insert(Pedido pedido) {
		Cliente a = pedidoFeign.findClienteByCorreo(pedido.getCorreoCliente());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pedido pedido) {
		Stream.of(pedido)
		.filter(p -> pedidoDAO.existsById(p.getId()))
		.peek(p -> pedidoDAO.save(p))
		.findFirst()
		.orElseThrow(() -> new RuntimeException("No existe pedido: " + pedido));
	}
	
	@Override
	public void deleteById(int id) {
		pedidoDAO.deleteById(id);
	}
	
	@Override
	public List<Pedido> findAll() {
		return (List<Pedido>) pedidoDAO.findAll();
	}
	
	@Override
	public Pedido findById(int id) {
		return pedidoDAO.findById(id)
				.stream()
				.filter(p -> p != null)
				.peek( p -> p.setPort(port))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No existe pedido: " + id));
	}

}
