package cl.usm.intentocertamen2023.Repositories;

import cl.usm.intentocertamen2023.Entities.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface peliculaRepository extends MongoRepository<Pelicula, String> {
}
