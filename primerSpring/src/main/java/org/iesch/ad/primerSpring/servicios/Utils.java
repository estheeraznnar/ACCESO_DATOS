package org.iesch.ad.primerSpring.servicios;

import org.springframework.stereotype.Service;

//Esto es un servicio
@Service
public class Utils {

    public String transformarMayuscula(String texto){
        return texto.toUpperCase();
    }

}
