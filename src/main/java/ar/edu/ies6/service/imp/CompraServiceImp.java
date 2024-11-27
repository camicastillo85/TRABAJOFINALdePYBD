package ar.edu.ies6.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Compra;
import ar.edu.ies6.service.ICompraService;
import ar.edu.ies6.util.AlmacenCompras;

//<!-- Esto No va Profe -->

@Service
@Qualifier("servicioCompraArrayList")
public class CompraServiceImp {
//public class CompraServiceImp implements ICompraService{
	
	/*
	@Override
	public void guardarCompra(Compra compra) {
		AlmacenCompras.compras.add(compra);
		
		System.out.println(AlmacenCompras.compras.get(0).getIdCompra());
	}
	@Override
	public void eliminarCompra(String idCompra){
		
	}
	@Override
	public void modificarCompra(Compra compraModificado) {
		
	}
	@Override
	public Compra consultarCompra(String idCompra) {
		return null;
	}
	@Override
	public List<Compra>listarTodosCompra(){
		
		return AlmacenCompras.compras;
		
	}
	@Override
	public List<Compra> listarTodosComprasActivos() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
