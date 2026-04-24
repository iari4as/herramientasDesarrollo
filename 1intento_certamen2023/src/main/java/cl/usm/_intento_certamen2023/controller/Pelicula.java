package cl.usm._intento_certamen2023.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "peliculas")
public class Pelicula {
    @GetMapping("/verPeliculas")
    ResponseEntity<List<Pelicula>> getAll(){
        return null;
    }

    @GetMapping("/peliculas/{limite}")
    ResponseEntity<List<Pelicula>>
}
