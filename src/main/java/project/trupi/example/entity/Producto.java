package project.trupi.example.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table (name = "products")
public class Producto {

    public Producto() {
    }

    public Producto(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Id
    @Schema(description= "Identity autogenerado", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "NAME", nullable = false)
    @Schema(description= "Product's name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Postre Oreo")
    private String name;

    @Column(name = "PRICE", nullable = false)
    @Schema(description= "Product's price", requiredMode = Schema.RequiredMode.REQUIRED, example = "5800")
    private double price;

    @Column(name = "BOUGHT")
    @Schema(description = "Product's Bought", example = "false")
    private boolean bought;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Cliente BoughtBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


