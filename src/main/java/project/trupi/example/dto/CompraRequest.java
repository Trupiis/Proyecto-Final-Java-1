package project.trupi.example.dto;

import project.trupi.example.entity.Cliente;
import project.trupi.example.entity.Producto;

import java.util.List;

public class CompraRequest {
    private Cliente cliente;
    private List<Producto>productos;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
