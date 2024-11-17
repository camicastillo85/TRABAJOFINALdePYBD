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
        return "index";  // Vista de inicio
    }

    // Mostrar formulario para agregar un nuevo producto
    @GetMapping("/formularioCrear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("producto", new Producto());  // Crear un nuevo objeto Producto
        return "formulario";  // Vista para el formulario de crear producto
    }

    // Mostrar formulario para editar un producto
    @GetMapping("/formularioActualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Integer id, Model model) {
        Producto producto = productoService.getProductoById(id);  // Obtener el producto por ID
        if (producto != null) {
            model.addAttribute("producto", producto);  // Pasar el producto al modelo
            return "formularioActualizar";  // Vista para el formulario de actualización
        }
        return "redirect:/productos?error=ProductoNoEncontrado";  // Si no se encuentra, redirigir con un error
    }

    // Crear un nuevo producto
    @PostMapping("/guardarProducto")
    public String guardarProducto(@ModelAttribute Producto producto, Model model) {
        productoService.createProducto(producto);  // Llamada al servicio para crear el producto
        return "redirect:/productos";  // Redirigir a la lista de productos
    }

    // Actualizar un producto
    @PostMapping("/actualizarProducto")
    public String actualizarProducto(@ModelAttribute Producto producto, Model model) {
        productoService.updateProducto(producto);  // Llamada al servicio para actualizar el producto
        return "redirect:/productos";  // Redirigir a la lista de productos
    }

    // Mostrar lista de productos activos
    @GetMapping("/productos")
    public String listaProductos(Model model) {
        model.addAttribute("productos", productoService.getAllProductos());  // Buscar productos activos
        return "listaProductos";  // Vista para listar los productos
    }

    // Eliminar (actualizar estado a false) un producto
    @PostMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);  // Llamada al servicio para eliminar el producto
        return "redirect:/productos";  // Redirigir a la lista de productos
    }
}
