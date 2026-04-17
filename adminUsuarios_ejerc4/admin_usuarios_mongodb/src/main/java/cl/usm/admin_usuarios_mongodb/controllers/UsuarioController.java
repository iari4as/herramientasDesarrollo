package cl.usm.admin_usuarios_mongodb.controllers;


import cl.usm.admin_usuarios_mongodb.entities.Usuario;
import cl.usm.admin_usuarios_mongodb.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService userService;


    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll(){
        try{
            List<Usuario> users = this.userService.getAll();
            return  ResponseEntity.ok(users);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/usuarios")
    public ResponseEntity<?>createUser(@RequestBody Usuario user){
        boolean res = this.userService.createUser(user);
        if (res){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/usuarios/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        return null;
    }
}
