package ar.edu.ies6.controller;

import org.springframework.stereotype.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Cliente;
import ar.edu.ies6.service.IClienteService;

@Controller
public class ClienteController {
	//gestiona el acceso ala vista
	@Autowired
	Cliente unCliente;

@Qualifier("servicioClienteBD")
     IClienteService clienteService;
	
//creado del cliente
@GetMapping("/cliente")
public ModelAndView getIndexWithCliente () {
	//transporte hacia la vista
	
	ModelAndView transportador = new ModelAndView("cliente");
	transportador.addObject("cliente", "unCliente");
	
	return transportador;
}

@PostMapping("/guardarCliente")
public ModelAndView guardarCliente(Cliente cliente) {
	
	//ClienteServiceImp clienteService = new ClienteServiceImp();
	clienteService.guardarCliente(cliente);
	
	ModelAndView transportador = new ModelAndView("listaCliente");
	transportador.addObject("listadoCliente", clienteService.listarTodosCliente());
	
	return transportador;
}
}