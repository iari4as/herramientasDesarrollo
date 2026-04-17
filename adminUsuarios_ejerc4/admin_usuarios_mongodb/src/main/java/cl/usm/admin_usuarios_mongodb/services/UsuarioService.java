package cl.usm.admin_usuarios_mongodb.services;

import cl.usm.admin_usuarios_mongodb.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    boolean createUser(Usuario user);
    List<Usuario>getAll();
    Optional<Usuario> findByEmail(String email);
}
