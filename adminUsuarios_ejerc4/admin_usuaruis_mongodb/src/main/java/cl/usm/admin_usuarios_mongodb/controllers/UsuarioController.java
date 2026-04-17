package cl.usm.admin_usuaruis_mongodb.controllers;

import cl.usm.admin_usuaruis_mongodb.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private
    //retorna a todos los usuarios
    @GetMapping("/usuarios")
    public ResponseEntity<?> getAll(){
        return null;
    }

    //Crea un usuario
    @PostMapping("/usuarios")
    public ResponseEntity<?> createUser(@RequestBody Usuario user){
        return null;
    }

    @GetMapping("/usuarios/{email}") //pathParam
    public ResponseEntity<?> findByEmail(){
        return null;
    }


}
