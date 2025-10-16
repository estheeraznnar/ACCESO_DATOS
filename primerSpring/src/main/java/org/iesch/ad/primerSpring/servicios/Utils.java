package org.iesch.ad.primerSpring.servicios;

import org.springframework.stereotype.Service;

import java.util.Random;

//Esto es un servicio
@Service
public class Utils {



    public String transformarMayuscula(String texto){
        return texto.toUpperCase();
    }

    public String generarContrasenasAZ(int numeroCaracteres){
        final String LETTERS = "abcdefghijklmnñopqrstuvwyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        StringBuilder passwd = new StringBuilder(numeroCaracteres);

        Random ra = new Random();
        for (int i = 0; i < numeroCaracteres; i++){
            int index = ra.nextInt(LETTERS.length());
            passwd.append(LETTERS.charAt(index));
        }

        return passwd.toString();
    }

    public String geraContrasenaAlfanumericas(int longitud) {

        final String LETTERS = "abcdefghijklmnñopqrstuvwyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ123456789";
        StringBuilder passwd = new StringBuilder(longitud);

        Random ra = new Random();
        for (int i = 0; i < longitud; i++){
            int index = ra.nextInt(LETTERS.length());
            passwd.append(LETTERS.charAt(index));
        }

        return passwd.toString();

    }

    public Double convierteAMillas(int km) {

        float AMILLAS = 1.609F;
        Double millas = (double) (km/AMILLAS);
        return millas;

    }

    public float convertirAFahrentheit(float temp) {
        return (temp *9/5) + 32;
    }
}
