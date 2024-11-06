package project.trupi.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.trupi.example.entity.Producto;


//Interfaz que hereda la JpaRepository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
