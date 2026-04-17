package cl.usm.admin_usuaruis_mongodb.services;

import cl.usm.admin_usuaruis_mongodb.entities.Usuario;
import cl.usm.admin_usuaruis_mongodb.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuariosServiceImpl implements usuarioService{

    @Autowired
    UsuariosRepository usuariosRepository;


    @Override
    public boolean createUser(Usuario user) {
        try {
            this.usuariosRepository.insert(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Usuario> getAll() {
        return this.usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return this.usuariosRepository.findById(email);
    }
}
