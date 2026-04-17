package cl.usm.admin_usuaruis_mongodb.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document (collation = "usuarios")
public class Usuario implements Serializable {

    @Id
    private String email;
    private String clave;
    private String nombre;
    private String apellido;
}