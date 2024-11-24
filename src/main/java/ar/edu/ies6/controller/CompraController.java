package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Compra;
//import ar.edu.ies6.repository.CompraRepository;
import ar.edu.ies6.service.ClienteService;
//import ar.edu.ies6.service.ICompraService;
import ar.edu.ies6.service.CompraService;
import ar.edu.ies6.service.ProductoService;

@Controller
public class CompraController {
	 @Autowired
	    private CompraService compraService;
 
	    @Autowired
	    private ClienteService clienteService;

	    @Autowired
	    private ProductoService productoService;

	    // Método para listar todas las compras
	    @GetMapping("/compras")
	    public ModelAndView listarCompras() {
	        ModelAndView modelAndView = new ModelAndView("listaCompras");
	        modelAndView.addObject("listadoCompras", compraService.listarTodos());
	        return modelAndView;
	    }

	    // Método para mostrar el formulario para una nueva compra
	    @GetMapping("/compras/nueva")
	    public ModelAndView nuevaCompraForm() {
	        ModelAndView modelAndView = new ModelAndView("formCompra");
	        modelAndView.addObject("compra", new Compra());
	        modelAndView.addObject("clientes", clienteService.listarTodos()); // Usar el servicio para obtener clientes
	        modelAndView.addObject("productos", productoService.listarTodos()); // Usar el servicio para obtener productos
	        return modelAndView;
	    }

	    /*
	    // Método para guardar una compra
	    @PostMapping("/compras/guardar")
	    public ModelAndView guardarCompra(@ModelAttribute Compra compra) {
	        compraService.guardar(compra);
	        ModelAndView modelAndView = new ModelAndView("listaCompras");
	        modelAndView.addObject("listadoCompras", compraService.listarTodos());
	        return modelAndView;
	    }*/
	    
	    @PostMapping("/compras/guardar")
	    public ModelAndView guardarCompra(@ModelAttribute Compra compra) {
	    	 
	    	 /* if (compra.getCantidad() == null) {
	         compra.setCantidad(1); // Asigna un valor predeterminado si es nulo
	     		}
	     		*/
	    	 
	        ModelAndView modelAndView = new ModelAndView("listaCompras");
	        try {
	            compraService.guardar(compra);
	        } catch (IllegalArgumentException e) {
	            // Si el producto es nulo, mostrar un mensaje de error
	            modelAndView.setViewName("formCompra");
	            modelAndView.addObject("compra", compra);
	            modelAndView.addObject("clientes", clienteService.listarTodos());
	            modelAndView.addObject("productos", productoService.listarTodos());
	            modelAndView.addObject("error", "El producto no puede estar vacío.");
	            return modelAndView;
	        }
	        modelAndView.addObject("listadoCompras", compraService.listarTodos());
	        return modelAndView;
	    }

	    // Método para editar una compra existente
	    @GetMapping("/compras/editar/{idCompra}")
	    public ModelAndView editarCompra(@PathVariable String idCompra) {
	        ModelAndView modelAndView = new ModelAndView("formCompra");
	        modelAndView.addObject("compra", compraService.obtenerPorId(idCompra));
	        modelAndView.addObject("clientes", clienteService.listarTodos());
	        modelAndView.addObject("productos", productoService.listarTodos());
	        return modelAndView;
	    }

	    // Método para eliminar una compra
	    @GetMapping("/compras/eliminar/{idCompra}")
	    public ModelAndView eliminarCompra(@PathVariable String idCompra) {
	        compraService.eliminar(idCompra);
	        ModelAndView modelAndView = new ModelAndView("listaCompras");
	        modelAndView.addObject("listadoCompras", compraService.listarTodos());
	        return modelAndView;
	    }
}
