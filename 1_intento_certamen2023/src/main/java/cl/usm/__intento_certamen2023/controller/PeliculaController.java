package cl.usm.__intento_certamen2023.controller;

import cl.usm.__intento_certamen2023.enteties.PeliculaEntetie;
import cl.usm.__intento_certamen2023.services.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/crearPelicula")
    ResponseEntity<PeliculaEntetie> createMovie(@RequestBody  @Valid PeliculaEntetie pelicula){
        try {
            boolean resPeliculaService = this.peliculaService.createMovie(pelicula);
            if (resPeliculaService){
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.internalServerError().build();
        }catch (Exception ex){
            return  ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/VerPeliculas")
    ResponseEntity<List <PeliculaEntetie>> getAll(){
        try {
            //falta el "filtro"
            List<PeliculaEntetie> peliculas = this.peliculaService.getAll();
            return ResponseEntity.ok(peliculas);
        }catch (Exception ex){
            return  ResponseEntity.internalServerError().build();
        }

    }
    @GetMapping("/peliculas/{limite}")
    ResponseEntity<List <PeliculaEntetie>> findByLimit(@PathVariable String limite){
        try {
            List<PeliculaEntetie> peliculasFiltradas = this.peliculaService.findByLimit(limite);
            return ResponseEntity.ok(peliculasFiltradas);
        }catch (Exception ex){
            return  ResponseEntity.internalServerError().build();
        }
    }


}
