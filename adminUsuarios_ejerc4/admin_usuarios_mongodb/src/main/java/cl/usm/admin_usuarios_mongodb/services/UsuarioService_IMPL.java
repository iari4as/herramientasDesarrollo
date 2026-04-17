package cl.usm.admin_usuarios_mongodb.services;

import cl.usm.admin_usuarios_mongodb.entities.Usuario;
import cl.usm.admin_usuarios_mongodb.repositories.UsuariosRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService_IMPL implements   UsuarioService {


    @Autowired
    UsuariosRepositories userRepo;

    @Override
    public boolean createUser(Usuario user) {

        try{
            this.userRepo.insert(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Usuario> getAll() {

        return this.userRepo.findAll();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return this.userRepo.findById(email);
    }
}
