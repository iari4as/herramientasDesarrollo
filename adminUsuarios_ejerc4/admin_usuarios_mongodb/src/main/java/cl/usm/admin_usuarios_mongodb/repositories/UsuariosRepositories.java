package cl.usm.admin_usuarios_mongodb.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import cl.usm.admin_usuarios_mongodb.entities.Usuario;

public interface UsuariosRepositories extends MongoRepository<Usuario, String>{
    // String es el tipo de dato de la clave primaria de entitie.Usuario
}
