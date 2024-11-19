package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Compra;
import ar.edu.ies6.service.ICompraService;



@Controller
public class CompraController {

	@Autowired
	Compra unCompra;
	
	@Autowired
	@Qualifier("servicioCompraBD")
	ICompraService compraService;
	
	/*
	@GetMapping("/compras")
	public String getIndex() {
		System.out.println("ingreso por aqui IndexCompras");
		return "indexCompra";
	}
	*/
	
	@GetMapping("/compras")
	public ModelAndView getIndexWithDocente() {
		//Codigo 
		//Creado el docente
		//Docente unDocente = new Docente();
		//unDocente.setApellido("Apellido001");
	    //unDocente.setNombre("Nombre001");
		//unDocente.setDni(231212);
		
		//transporte hacia la vista
		ModelAndView transportador = new ModelAndView("indexCompra");
		transportador.addObject("compras",unCompra);
        //transportador.addObject("band",false);
		return transportador;
	}
	
	@GetMapping("/listadoCompra")
	public ModelAndView getAllCompra() {
	    ModelAndView transportador = new ModelAndView("listaCompras");
	    transportador.addObject("listadoCompras", compraService.listarTodosComprasActivos());
	    return transportador;
	}
	
	@PostMapping("/guardarCompra")
	public ModelAndView guardarCompra(Compra compra) {
		
		//DocenteServiceImp docenteService = new  DocenteServiceImp();
		compraService.guardarCompra(compra);
		
		ModelAndView transportador = new ModelAndView("listaCompras");
		transportador.addObject("listadoCompras", compraService.listarTodosComprasActivos());
		//transportador.addObject("listadoDocentes", docenteService.listarTodosDocente());
		return transportador;
	}
	
	//eliminar
	@GetMapping("/eliminarDocente/{idCompra}")
	public ModelAndView deleteCompra(@PathVariable(name="idCompra") String idCompra) {
		
		compraService.eliminarCompra(idCompra);
		
		ModelAndView modelView= new ModelAndView("listaCompras");
		modelView.addObject("listadoCompras",compraService.listarTodosComprasActivos());
		
		return modelView;
	}
	
	//modificar
	@GetMapping("/modificarCompra/{idCompra}")
	public ModelAndView modificarDocente(@PathVariable(name="idCompra") String idCompra) {
		//el parametro del constructor ModelAndView es una Vista HTML
		ModelAndView modelView= new ModelAndView("indexCompra");
		modelView.addObject("compra",compraService.consultarCompra(idCompra));
		modelView.addObject("band",true);
		
		return modelView;
	}
	
}
