package cl.usm.__intento_certamen2023.repositories;

import cl.usm.__intento_certamen2023.enteties.PeliculaEntetie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeliculasRepo extends MongoRepository<PeliculaEntetie, String> {
}
