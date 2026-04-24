package cl.usm.intentocertamen2023.Services;

import cl.usm.intentocertamen2023.Entities.Pelicula;

import java.util.List;

public interface peliculaService{
    boolean createMovie(Pelicula peli);
    List<Pelicula> getAll();
    List<Pelicula> findByLimite(String limite);
}
