package project.trupi.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.trupi.example.dto.CompraRequest;
import project.trupi.example.entity.Cliente;
import project.trupi.example.entity.Compra;
import project.trupi.example.entity.Producto;
import project.trupi.example.service.CompraService;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping
    public Compra realizarCompra(@RequestBody CompraRequest compraRequest){
        Cliente cliente = compraRequest.getCliente();
        List<Producto>productos = compraRequest.getProductos();

        return compraService.registrarCompra(cliente, productos);
    }

}
