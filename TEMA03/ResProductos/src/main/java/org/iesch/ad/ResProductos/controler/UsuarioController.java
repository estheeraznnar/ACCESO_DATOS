package org.iesch.ad.ResProductos.controler;

import org.iesch.ad.ResProductos.modelo.Usuario;
import org.iesch.ad.ResProductos.modelo.UsuarioDTOpeticion;
import org.iesch.ad.ResProductos.modelo.UsuarioDTOrespuesta;
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
    public ResponseEntity<?> registra (@RequestBody UsuarioDTOpeticion usuarioDTOpeticion){
        Usuario user = Usuario.builder()
                .nombre(usuarioDTOpeticion.getNombre())
                .passwd(usuarioDTOpeticion.getPassword()).build();
        Usuario usuario1 = usuariosService.adduser(user);
        URI location = URI.create("/usuario/" + usuario1.getId());
        UsuarioDTOrespuesta usuarioDTOrespuesta = UsuarioDTOrespuesta
                .builder().nombre(usuario1.getNombre()).build();
        return ResponseEntity.created(location).body(usuarioDTOrespuesta);
    }
}
