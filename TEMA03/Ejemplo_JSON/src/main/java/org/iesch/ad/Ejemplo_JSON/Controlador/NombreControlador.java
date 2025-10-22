package org.iesch.ad.Ejemplo_JSON.Controlador;

import org.iesch.ad.Ejemplo_JSON.modelo.Persona;
import org.iesch.ad.Ejemplo_JSON.service.GuardarDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NombreControlador {
    @Autowired
    GuardarDatos guardarDatos;

    @PostMapping("/persona")
    //Reciba el JSON y lo procese y lo guarde en un fichero
    public String guarda (@RequestBody Persona persona){
        System.out.println(persona);
        return guardarDatos.guarda(persona);
    }
}
