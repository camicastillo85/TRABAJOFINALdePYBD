package ar.edu.ies6.repository;


import ar.edu.ies6.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Buscar productos que están activos
    List<Producto> findByEstadoTrue();
}
