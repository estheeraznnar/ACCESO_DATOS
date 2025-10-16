package org.iesch.ad.primerSpring.controlador;

import org.iesch.ad.primerSpring.servicios.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*Generador de contraseñas: Implementa un servicio REST con dos endpoints que genere
contraseñas aleatorias. El primer endpoint debe generar contraseñas de caracteres [a-z A-
Z] y debe recibir como parámetro el número de caracteres de la contraseña a generar. El
segundo endpoint debe generar contraseñas alfanuméricas. La longitud de la contraseña
debe ser fija.*/
@RestController
public class PasswordController {
    @Autowired
    Utils utils;

    /*Ejercicio 1.a*/
    @GetMapping ("/generaEJ1a/{numeroCaracteres}")
    public String Ejer01 (@PathVariable int numeroCaracteres){

        String pass  = utils.generarContrasenasAZ(numeroCaracteres);

        return pass;
    }

    /*Ejercicio 1.b*/
    @GetMapping("/generaEJ1b")
    public String Ejer01_2(){
        int longitud = 32;
        String pass = utils.geraContrasenaAlfanumericas(longitud);
        return pass;
    }

}
