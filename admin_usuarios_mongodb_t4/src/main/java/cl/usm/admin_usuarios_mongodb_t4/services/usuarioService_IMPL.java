package cl.usm.admin_usuarios_mongodb_t4.services;

import cl.usm.admin_usuarios_mongodb_t4.entities.Usuario;
import cl.usm.admin_usuarios_mongodb_t4.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class usuarioService_IMPL implements usuarioService{
    @Autowired
    UsuarioRepositories userRepo;

    @Override
    public boolean createUser(Usuario user) {
        try {
            this.userRepo.insert(user);
            return true;
        }catch (Exception ex){
            return  false;
        }
    }

    @Override
    public List<Usuario> getAll() {
        System.out.println("lista de usuarios: "+this.userRepo.findAll());
        return this.userRepo.findAll();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return this.userRepo.findById(email);
    }
}
