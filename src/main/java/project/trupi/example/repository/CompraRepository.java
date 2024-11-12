package project.trupi.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.trupi.example.entity.Compra;

public interface CompraRepository extends JpaRepository <Compra, Long> {
}
