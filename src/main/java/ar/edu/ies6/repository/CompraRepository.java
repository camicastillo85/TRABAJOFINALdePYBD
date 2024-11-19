package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.ies6.model.Compra;


public interface CompraRepository extends CrudRepository<Compra,String> {
	
	List<Compra>findByEstado(Boolean estado);
}
