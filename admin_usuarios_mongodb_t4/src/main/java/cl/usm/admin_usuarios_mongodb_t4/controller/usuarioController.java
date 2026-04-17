package cl.usm.admin_usuarios_mongodb_t4.controller;

import cl.usm.admin_usuarios_mongodb_t4.entities.Usuario;
import cl.usm.admin_usuarios_mongodb_t4.services.usuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
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
    public ResponseEntity<Optional<Usuario>>findByEmail(@PathVariable String email) {
        try {
            Optional<Usuario> usuarioEncontrado = this.userService.findByEmail(email);
            return ResponseEntity.ok(usuarioEncontrado);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
