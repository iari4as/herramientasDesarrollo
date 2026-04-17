package cl.usm.admin_usuarios_mongodb_t4.services;

import cl.usm.admin_usuarios_mongodb_t4.entities.Usuario;
import cl.usm.admin_usuarios_mongodb_t4.repositories.UsuarioRepositories;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class usuarioService_IMPL implements usuarioService{
    @Autowired
    UsuarioRepositories userRepo;

    @Override
    public boolean createUser(Usuario user) {
        try {
            //largo de 10
            user.setClave(RandomStringUtils.secure().next(10));

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

    @Override
    public List<Usuario> filter(String query) {
        // 1: encontrar_todo
        List<Usuario> usuarios = this.getAll();
        // 2: streams
        List<Usuario> filtrados = usuarios.stream()
                .filter(
                        usuario ->
                                usuario.getNombre().toLowerCase().contains(query.toLowerCase()) ||
                                usuario.getApellido().toLowerCase().contains(query.toLowerCase())
                ).collect(Collectors.toList());
        return filtrados;
    }
}
