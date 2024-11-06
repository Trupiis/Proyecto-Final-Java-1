package project.trupi.example.controller;


import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.trupi.example.dto.ErrorResponseDto;
import project.trupi.example.entity.Producto;
import project.trupi.example.service.ProductoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    public ProductoController(ProductoService service){
        this.service = service;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters",
            content = {@Content(mediaType = "aplication/json", schema= @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<Producto>> getALL() {
        Iterable<Producto> productos = service.getProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<Producto>> getById(@PathVariable Long id) {
        Optional<Producto> producto = service.getById(id);

        if (producto.isPresent()){
            return ResponseEntity.ok(producto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        try{
            Producto nuevoProducto = service.save(producto);
            return ResponseEntity.ok(nuevoProducto);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
