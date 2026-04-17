package cl.usm.admin_usuarios_mongodb_t4.repositories;

import cl.usm.admin_usuarios_mongodb_t4.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositories extends MongoRepository<Usuario, String> {
}
