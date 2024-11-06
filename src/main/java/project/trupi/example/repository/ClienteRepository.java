package project.trupi.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.trupi.example.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
