package cl.usm.admin_usuarios_mongodb_t4.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    //agregar validaziones
    @Id
    @NotBlank(message = "ingresa correo")
    @Email(message = "email debe ser valido")
    private String email;
    private String apellido;
    @NotBlank(message = "ingrese nombre")
    private String nombre;
    private String clave; //clave generada y no provista por user (libreria externa: apache common lang)
}
