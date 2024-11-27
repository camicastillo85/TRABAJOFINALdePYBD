package ar.edu.ies6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Producto;
//import ar.edu.ies6.repository.ProductoRepository;
import ar.edu.ies6.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
    private ProductoService productoService;

    // Método para listar todos los productos
    @GetMapping("/productos")
    public ModelAndView listarProductos() {
        ModelAndView modelAndView = new ModelAndView("listaProductos");
        modelAndView.addObject("listadoProductos", productoService.listarTodos());
        return modelAndView;
    }

    // Método para mostrar el formulario para un nuevo producto
    @GetMapping("/productos/nuevo")
    public ModelAndView nuevoProductoForm() {
        ModelAndView modelAndView = new ModelAndView("formProducto");
        modelAndView.addObject("producto", new Producto());
        return modelAndView;
    }

    // Método para guardar un producto
    @PostMapping("/productos/guardar")
    public ModelAndView guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardar(producto);
        ModelAndView modelAndView = new ModelAndView("listaProductos");
        modelAndView.addObject("listadoProductos", productoService.listarTodos());
        return modelAndView;
    }

    // Método para editar un producto existente
    @GetMapping("/productos/editar/{idProducto}")
    public ModelAndView editarProducto(@PathVariable String idProducto) {
        ModelAndView modelAndView = new ModelAndView("formProducto");
        modelAndView.addObject("producto", productoService.obtenerPorId(idProducto));
        return modelAndView;
    }

    // Método para eliminar un producto
    @GetMapping("/productos/eliminar/{idProducto}")
    public ModelAndView eliminarProducto(@PathVariable String idProducto) {
        productoService.eliminar(idProducto);
        ModelAndView modelAndView = new ModelAndView("listaProductos");
        modelAndView.addObject("listadoProductos", productoService.listarTodos());
        return modelAndView;
    }
}

