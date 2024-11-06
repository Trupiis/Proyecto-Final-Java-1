package project.trupi.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.trupi.example.entity.Cliente;
import project.trupi.example.entity.Producto;
import project.trupi.example.repository.ClienteRepository;
import project.trupi.example.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    //La propiedad va a ser inyectada por medio del constructor

    @Autowired
    private ProductoRepository repository;

    public ProductoService(ProductoRepository repository){
        this.repository = repository;
    }

    public Producto save(Producto producto){
        return repository.save(producto);
    }

    public List<Producto> getProductos(){
        return repository.findAll();
    }

    public Optional<Producto> getById(Long id){
        return repository.findById(id);
    }

}
