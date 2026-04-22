package cl.usm.__intento_certamen2023.services;

import cl.usm.__intento_certamen2023.enteties.PeliculaEntetie;

import java.util.List;

public interface PeliculaService {
    boolean createMovie (PeliculaEntetie pelicula);
    List<PeliculaEntetie> getAll();
    List<PeliculaEntetie> findByLimit(String limite);

}
