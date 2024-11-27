package ar.edu.ies6.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Compra;
import ar.edu.ies6.repository.CompraRepository;
import ar.edu.ies6.service.ICompraService;
//<!-- Esto No va Profe -->

@Service
@Qualifier("servicioCompraBD")
public class CompraServiceBD {
//public class CompraServiceBD implements ICompraService{	
	
	/*
	@Autowired
	CompraRepository compraRepository;

	@Override
	public void guardarCompra(Compra compra) {
		// TODO Auto-generated method stub
		compra.setEstado(true);
		compraRepository.save(compra);
	}

	@Override
	public void eliminarCompra(String idCompra) {
		// TODO Auto-generated method stub
		
		Optional<Compra>docenteEncontrado=compraRepository.findById(idCompra);
		docenteEncontrado.get().setEstado(false);
		compraRepository.save(docenteEncontrado.get());
	}

	@Override
	public void modificarCompra(Compra compraModificado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compra consultarCompra(String idCompra) {
		// TODO Auto-generated method stub
		return compraRepository.findById(idCompra).get();
	}

	@Override
	public List<Compra> listarTodosCompra() {
		// TODO Auto-generated method stub
		return (List<Compra>) compraRepository.findAll();
	}

	@Override
	public List<Compra> listarTodosComprasActivos() {
		// TODO Auto-generated method stub
		return (List<Compra>) compraRepository.findByEstado(true);
	}

	
	*/
}
