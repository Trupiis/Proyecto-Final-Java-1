package project.trupi.example.controller;


import ch.qos.logback.core.net.server.Client;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.trupi.example.entity.Cliente;
import project.trupi.example.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.findAll();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable String id) {
        Optional<Cliente> clientes = clienteService.findById(id);

        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> create (@RequestBody Cliente cliente){
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }

        Cliente newCliente = clienteService.create(cliente);

        return ResponseEntity.ok(newCliente);
    }
}
