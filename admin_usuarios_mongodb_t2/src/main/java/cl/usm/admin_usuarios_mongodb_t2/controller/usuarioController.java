package cl.usm.admin_usuarios_mongodb_t2.controllers;

import cl.usm.admin_usuarios_mongodb_t2.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import cl.usm.admin_usuarios_mongodb_t2.services.usuarioService;

import java.util.List;

public class usuarioController {
    @Autowired
    private usuarioService userService;

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> getAll(){
        try {
            List<Usuario> usuarios = this.userService.getAll();
           return ResponseEntity.ok(usuarios);

        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/usuario")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario user){
        boolean resultadoService = this.userService.createUser(user);
        if (resultadoService){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/usuario/{email}")
    public ResponseEntity<Usuario>findByEmail(@PathVariable String email){
        return null;
    }

}
