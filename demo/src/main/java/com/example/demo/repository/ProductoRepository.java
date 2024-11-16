package com.example.demo.repository;


import com.example.demo.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Buscar productos que están activos
    List<Producto> findByEstadoTrue();
}
