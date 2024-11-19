package ar.edu.ies6.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Compra;

@Service
public interface ICompraService {
	
	public void guardarCompra(Compra compra);
	public void eliminarCompra(String idCompra);
	public void modificarCompra(Compra compraModificado);
	public Compra consultarCompra(String idCompra);
	public List<Compra>listarTodosCompra();
	public List<Compra>listarTodosComprasActivos();

}
