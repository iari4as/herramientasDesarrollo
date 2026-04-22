package cl.usm.admin_usuarios_mongodb_t4.controller;

import cl.usm.admin_usuarios_mongodb_t4.entities.Usuario;
import cl.usm.admin_usuarios_mongodb_t4.services.usuarioService;
import jakarta.validation.Valid;
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


    // filtrar
    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> getAll(@RequestParam(required = false) String q){
        try {
            // implementacion del filtro opcional (el required ayuda a esto)
            if(q != null && !q.isEmpty()){
                List<Usuario> filtrados = this.userService.filter(q);
                return ResponseEntity.ok(filtrados);
            }

            List<Usuario> usuarios = this.userService.getAll();
            return ResponseEntity.ok(usuarios);

        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/usuario")
    public ResponseEntity<Usuario> createUser(@RequestBody @Valid Usuario user){
        boolean resultadoService = this.userService.createUser(user);
        if (resultadoService){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/usuario/{email}")
    public ResponseEntity<Usuario>findByEmail(@PathVariable String email) {
        Optional<Usuario> usuarioEncontrado = this.userService.findByEmail(email);

        try {
            if (usuarioEncontrado.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(usuarioEncontrado.get());
        }catch (Exception ex){
            return  ResponseEntity.internalServerError().build();
        }
    }
}
