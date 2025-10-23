package org.iesch.ad.ResProductos.controler;

import org.iesch.ad.ResProductos.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    Map<Long, Usuario> usuarios;

    public Usuario adduser(Usuario usuario) {
        Long maxKey = Collections.max(usuarios.keySet());
        usuario.setId(maxKey+1);
        usuarios.put(maxKey + 1, usuario);
        return usuario;
    }
}
