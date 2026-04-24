package cl.usm.intentocertamen2023.Services;

import cl.usm.intentocertamen2023.Entities.Pelicula;
import cl.usm.intentocertamen2023.Repositories.peliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class peliculaService_IMPL implements peliculaService{
    String MENOR_EDAD = "MENOR_EDAD";
    String ADOLESCENTES = "ADOLESCENTES";
    String MAYOR = "MAYOR";

    @Autowired
    peliculaRepository peliRepo;


    @Override
    public boolean createMovie(Pelicula peli) {
        try {
            peli.setId(UUID.randomUUID().toString().replace("-",""));
            this.peliRepo.insert(peli);
            return true;

        }catch (Exception ex){
            return false;
        }

    }

    @Override
    public List<Pelicula> getAll() {

        return this.peliRepo.findAll();
    }


    // mi funcion auxiliar
    public List<Pelicula> filtrarPeliculasPorRango(
            List<Pelicula> peliculas,
            int edadMin,
            int edadMax
    ) {
        List<Pelicula> peliculasFiltradas = new ArrayList<>();

        for (int i = 0; i < peliculas.size(); i++) {
            int edad = peliculas.get(i).getEdad_minima();
            System.out.println("edad " + edad);
            if (edadMin <= edad && edad <= edadMax) {
                peliculasFiltradas.add(peliculas.get(i));
                System.out.println("edad if: " + peliculas.get(i));
            }
        }

        return peliculasFiltradas;
    }

    @Override
    public List<Pelicula> findByLimite(String limite) {
        List<Pelicula>  peliculas = this.peliRepo.findAll();
        List<Pelicula> peliculasFiltradas = new ArrayList<>();

        if(limite.toUpperCase().equals(this.MENOR_EDAD)){
            peliculasFiltradas = filtrarPeliculasPorRango(peliculas,0,15);
            return peliculasFiltradas;
        }
        if(limite.toUpperCase().equals(this.ADOLESCENTES)){
            peliculasFiltradas = filtrarPeliculasPorRango(peliculas,16,17);
            return peliculasFiltradas;
        }
        if(limite.toUpperCase().equals(this.MAYOR)){
            peliculasFiltradas = filtrarPeliculasPorRango(peliculas,18,Integer.MAX_VALUE);
            return peliculasFiltradas;
        }
        return peliculasFiltradas;
    }
}
