package org.iesch.ad.demoValid.controlador;

import jakarta.validation.Valid;
import org.iesch.ad.demoValid.modelo.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsiarioController {

    @PostMapping                                //Lo coge y lo transformma -- si no esta el @RequestBody da error
    public ResponseEntity<String> createUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO){
        System.out.println(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO.toString());
    }
}
