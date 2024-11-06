
package project.trupi.example.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID")
    @Schema(description = "Client's Id", requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private UUID id;


    @Column(name = "NAME", nullable = false)
    @Schema(description = "User's Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Elian")
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Schema(description = "Email's Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Eliantrupianogg@gmail.com")
    private String email;

    @OneToMany(mappedBy = "BoughtBy", cascade = CascadeType.ALL)
    private List<Producto>BoughtProducts;
}