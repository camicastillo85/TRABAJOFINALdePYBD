package ar.edu.ies6.controller;


import ar.edu.ies6.model.Producto;
//import com.example.demo.repository.ProductoRepository;
import ar.edu.ies6.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
   
@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Página de inicio
    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "index";  
    }

    // Mostrar formulario para agregar un nuevo producto
    @GetMapping("/formularioCrear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("producto", new Producto());  
        return "formulario";  
    }

    // Mostrar formulario para editar un producto
    @GetMapping("/formularioActualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Integer id, Model model) {
        Producto producto = productoService.getProductoById(id);  
        if (producto != null) {
            model.addAttribute("producto", producto);  
            return "formularioActualizar";  
        }
        return "redirect:/productos?error=ProductoNoEncontrado";  
    }

    // Crear un nuevo producto
    @PostMapping("/guardarProducto")
    public String guardarProducto(@ModelAttribute Producto producto, Model model) {
        productoService.createProducto(producto);  
        return "redirect:/productos";  
    }

    // Actualizar un producto
    @PostMapping("/actualizarProducto")
    public String actualizarProducto(@ModelAttribute Producto producto, Model model) {
        productoService.updateProducto(producto);  
        return "redirect:/productos";  
    }

    // Mostrar lista de productos activos
    @GetMapping("/productos")
    public String listaProductos(Model model) {
        model.addAttribute("productos", productoService.getAllProductos());  
        return "listaProductos";
    }

    // Eliminar (actualizar estado a false) un producto
    @PostMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);  
        return "redirect:/productos";  
    }
}
