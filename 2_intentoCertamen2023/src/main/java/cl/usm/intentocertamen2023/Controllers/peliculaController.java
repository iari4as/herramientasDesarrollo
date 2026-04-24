package cl.usm.intentocertamen2023.Controllers;


import cl.usm.intentocertamen2023.Entities.Pelicula;
import cl.usm.intentocertamen2023.Services.peliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class peliculaController {

    @Autowired
    private peliculaService peliculaService;

    @GetMapping("/verPeliculas")
    ResponseEntity<List<Pelicula>> getAll(){
        //try-catch
        try{
            List<Pelicula> peliculas = this.peliculaService.getAll();
            return ResponseEntity.ok(peliculas);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/crearPelicula")
    ResponseEntity<Pelicula> createMovie(@RequestBody @Valid Pelicula peli){
        try {
            boolean res = this.peliculaService.createMovie(peli);
            if (res){
                return ResponseEntity.ok(peli);
            }
            return ResponseEntity.badRequest().build();

        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/peliculas/{limite}")
    ResponseEntity<List<Pelicula>> findByLimite(@PathVariable String limite){
        try {
            List<Pelicula> peliculasFiltradas = this.peliculaService.findByLimite(limite);
            return ResponseEntity.ok(peliculasFiltradas);
        }catch (Exception ex){
            return  ResponseEntity.internalServerError().build();
        }
    }

}
