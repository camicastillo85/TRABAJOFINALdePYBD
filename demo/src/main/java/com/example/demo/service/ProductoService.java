package com.example.demo.service;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos activos
    public List<Producto> getAllProductos() {
        return productoRepository.findByEstadoTrue();
    }

    // Obtener un producto por su ID
    public Producto getProductoById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        return productoRepository.findById(id).orElse(null);
    }

    // Crear un nuevo producto
 
public void createProducto(Producto producto) {
    if (producto == null) {
        throw new IllegalArgumentException("El producto no puede ser nulo.");
    }
    // El ID será generado automáticamente por la base de datos
    productoRepository.save(producto);
}

    

    // Actualizar un producto
    public void updateProducto(Producto producto) {
        if (producto == null || producto.getId() == null) {
            throw new IllegalArgumentException("El producto o el ID no pueden ser nulos.");
        }
        if (!productoRepository.existsById(producto.getId())) {
            throw new IllegalArgumentException("Producto con el ID " + producto.getId() + " no encontrado.");
        }
        productoRepository.save(producto);  // Actualizar el producto
    }

    // "Eliminar" un producto (actualizar el estado a false)
    public Producto eliminarProducto(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setEstado(false);  // Cambiar el estado a false para simular eliminación
            return productoRepository.save(producto);
        }
        return null;  // Si el producto no existe, devuelve null
    }
}
