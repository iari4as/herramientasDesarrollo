package cl.usm.admin_usuarios_mongodb_t4.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuario")
public class Usuario implements Serializable {
    @Id
    private String email;
    private String apellido;
    private String nombre;
    private String clave;
}
