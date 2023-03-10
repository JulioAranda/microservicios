package com.netec.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.netec.entities.Articulo;

public interface IArticuloDAO extends CrudRepository<Articulo, Integer> {
	
	@Query("SELECT a FROM Articulo a WHERE a.marca=:marca")
	Optional<List<Articulo>> buscarPorMarca(@Param( value = "marca")String marca);
}
