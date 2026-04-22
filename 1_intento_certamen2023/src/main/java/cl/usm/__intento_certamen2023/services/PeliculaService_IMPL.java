package cl.usm.__intento_certamen2023.services;

import cl.usm.__intento_certamen2023.enteties.PeliculaEntetie;
import cl.usm.__intento_certamen2023.repositories.PeliculasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PeliculaService_IMPL implements PeliculaService{
    @Autowired
    PeliculasRepo peli_repo;
    String MENOR_EDAD = "MENOR_EDAD";
    String ADOLESCENTES = "ADOLESCENTES";
    String MAYOR = "MAYOR";

    @Override
    public boolean createMovie(PeliculaEntetie pelicula) {
        try {
            pelicula.setId(UUID.randomUUID().toString().replace("-","")); //set del identificador
            this.peli_repo.insert(pelicula);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<PeliculaEntetie> getAll() {
        try {
            List <PeliculaEntetie> peliculas = this.peli_repo.findAll();
            return peliculas;
        }catch (Exception ex){
            return null;
        }
    }

    // mi funcion auxiliar
    public List<PeliculaEntetie> filtrarPeliculasPorRango(
            List<PeliculaEntetie> peliculas,
            int edadMin,
            int edadMax
    ) {
        List<PeliculaEntetie> peliculasFiltradas = new ArrayList<>();

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
    public List<PeliculaEntetie> findByLimit(String limite) {

        List<PeliculaEntetie> peliculas = this.peli_repo.findAll();
        List<PeliculaEntetie> peliculasFiltradas = new ArrayList<>();
        // la logica ocupada aca no me termina de combencer: Que pasa si ponen un numero mas grande que el MAX_VALUE
        if (limite.toUpperCase().equals(this.MENOR_EDAD)) {
            peliculasFiltradas = filtrarPeliculasPorRango(peliculas, 0, 15);
            System.out.println("menor edad");
            return peliculasFiltradas;
        }

        if (this.ADOLESCENTES.equalsIgnoreCase(limite)) {
            peliculasFiltradas = filtrarPeliculasPorRango(peliculas, 16, 17);
            return peliculasFiltradas;
        }

        if (this.MAYOR.equalsIgnoreCase(limite)) {
            peliculasFiltradas = filtrarPeliculasPorRango(peliculas, 18, Integer.MAX_VALUE);
            return peliculasFiltradas;
        }
        return peliculasFiltradas;

    }
}
