package project.trupi.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.trupi.example.entity.Cliente;
import project.trupi.example.entity.Compra;
import project.trupi.example.entity.Producto;
import project.trupi.example.repository.CompraRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;

    public Compra registrarCompra(Cliente cliente, List<Producto> productos) {
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProductos(productos);
        compra.setFechaCompra(LocalDateTime.now());

        double total = productos.stream().mapToDouble(Producto::getPrice).sum();
        compra.setTotal(total);

        return compraRepository.save(compra);

    }
}