package ar.edu.ies6.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Cliente;
//import ar.edu.ies6.repository.ClienteRepository;
import ar.edu.ies6.service.ClienteService;

@Controller//A1

public class ClienteController {
	//todo A1
	@Autowired
    private ClienteService clienteService;

    // Método para listar todos los clientes
    @GetMapping("/clientes")
    public ModelAndView listarClientes() {
        ModelAndView modelAndView = new ModelAndView("listaClientes");
        modelAndView.addObject("listadoClientes", clienteService.listarTodos());
        modelAndView.addObject("band",false);//A1
        return modelAndView;
    }

    // Método para mostrar el formulario para un nuevo cliente
    @GetMapping("/clientes/nuevo")
    public ModelAndView nuevoClienteForm() {
        ModelAndView modelAndView = new ModelAndView("formCliente");
        modelAndView.addObject("cliente", new Cliente());
        return modelAndView;
    }

    // Método para guardar un cliente
    @PostMapping("/clientes/guardar")
    public ModelAndView guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.guardar(cliente);
        ModelAndView modelAndView = new ModelAndView("listaClientes");
        modelAndView.addObject("listadoClientes", clienteService.listarTodos());
        return modelAndView;
    }

    // Método para editar un cliente existente
    @GetMapping("/clientes/editar/{dniCliente}")
    public ModelAndView editarCliente(@PathVariable String dniCliente) {
        ModelAndView modelAndView = new ModelAndView("formCliente");
        modelAndView.addObject("cliente", clienteService.obtenerPorDni(dniCliente));
        modelAndView.addObject("band",true);//A1
        return modelAndView;
    }

    // Método para eliminar un cliente
    @GetMapping("/clientes/eliminar/{dniCliente}")
    public ModelAndView eliminarCliente(@PathVariable String dniCliente) {
        clienteService.eliminar(dniCliente);
        ModelAndView modelAndView = new ModelAndView("listaClientes");
        modelAndView.addObject("listadoClientes", clienteService.listarTodos());
        return modelAndView;
    }

