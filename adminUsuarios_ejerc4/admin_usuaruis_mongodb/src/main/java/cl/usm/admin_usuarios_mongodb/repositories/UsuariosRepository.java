package cl.usm.admin_usuaruis_mongodb.repositories;

import cl.usm.admin_usuaruis_mongodb.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuariosRepository extends MongoRepository<Usuario, String> {

}
