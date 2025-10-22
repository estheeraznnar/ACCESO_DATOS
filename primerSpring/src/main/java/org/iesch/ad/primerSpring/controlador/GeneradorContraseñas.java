package org.iesch.ad.primerSpring.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

/*Generador de contraseñas: Implementa un servicio REST con dos endpoints que genere
contraseñas aleatorias. El primer endpoint debe generar contraseñas de caracteres [a-z A-
Z] y debe recibir como parámetro el número de caracteres de la contraseña a generar. El
segundo endpoint debe generar contraseñas alfanuméricas. Debe recibir como parámetro
el número de caracteres de la contraseña a generar*/

@RestController
public class GeneradorContraseñas {
    Random ra = new Random();

    @PostMapping("/generarLetras")
    public Map<String, String> generarLetras(@RequestBody Map<String, Integer> body){
        int longitud = body.get("longitud");
        String cont = generarContraLetras(longitud);
        return Map.of("contraseña", cont);
    }

    @PostMapping("/genera")
    public Map<String, String> genera(@RequestBody Map<String, Integer> body){
        int longitud = body.get("longitud");
        String cont = generarContraAlfanumerica(longitud);
        return Map.of("contraseña", cont);
    }

    private String generarContraLetras(int longitud) {
        String caracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        StringBuilder contra = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int j = ra.nextInt(caracteres.length());
            contra.append(caracteres.charAt(j));
        }
        return contra.toString();
    }

    private String generarContraAlfanumerica(int longitud) {
        String carac = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
        StringBuilder contra = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int j = ra.nextInt(carac.length());
            contra.append(carac.charAt(j));
        }
        return contra.toString();
    }

}
