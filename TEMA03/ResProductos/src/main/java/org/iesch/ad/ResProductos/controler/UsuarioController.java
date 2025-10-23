package org.iesch.ad.ResProductos.controler;

import org.iesch.ad.ResProductos.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
public class UsuarioController {

    @Autowired
    Map<Long, Usuario> usuarios;

    @Autowired
    UsuarioService usuariosService;

    @PostMapping("/usuario")
    public ResponseEntity<?> registra (@RequestBody Usuario usuario){
        Usuario usuario1 = usuariosService.adduser(usuario);
        URI location = URI.create("/usuario/" + usuario1.getId());
        return ResponseEntity.created(location).body(usuario1);
    }
}
