package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.Compra;

@Repository//A1
public interface CompraRepository extends CrudRepository<Compra,String> {
	
	//public interface CompraRepository extends JpaRepository<Compra, String> 
	 List<Compra> findByCliente_DniCliente(String clienteId); //A1
	 List<Compra> findByProducto_IdProducto(String productoId);//A1
	
	List<Compra>findByEstado(Boolean estado);
}
