package cl.usm.admin_usuarios_mongodb_t4.services;

import cl.usm.admin_usuarios_mongodb_t4.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface usuarioService {
    //solo declaraciones de los servicios
    boolean createUser(Usuario user);
    List<Usuario> getAll();
    Optional<Usuario> findByEmail(String email);
    // proteccion de nullidad
}
