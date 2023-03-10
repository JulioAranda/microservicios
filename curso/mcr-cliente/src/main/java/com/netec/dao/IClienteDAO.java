package com.netec.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.netec.entities.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Integer> {
	
	@Query("SELECT c FROM Cliente c WHERE c.correo=:correo")
	Optional<List<Cliente>> buscarPorCorreo(@Param( value = "correo")String correo);
}

