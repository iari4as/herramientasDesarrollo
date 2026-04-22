package cl.usm.__intento_certamen2023.enteties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Peliculas")
public class PeliculaEntetie {

    @Id
    private String id;
    @NotBlank(message = "ingresar nombre")
    private String nombre;
    private String nombreAbreviado;
    @Positive(message = "edad minima deve ser positiva")
    private int edad_minima;

    private String genero;

}

