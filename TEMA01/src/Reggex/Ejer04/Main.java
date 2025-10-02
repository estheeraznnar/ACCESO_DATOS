package Reggex.Ejer04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Validar una contraseña: (complicado)

Descripción: Validar si una cadena cumple con los requisitos de una contraseña segura
(al menos 8 caracteres, una letra mayúscula, una letra minúscula, un número y un
carácter especial).*/
public class Main {

    public static void main(String[] args) {
        String texto = "SJDKfakdk156@~#";
        //1 Extrar las direcciones
        extraerContraseña(texto);
    }

    private static void extraerContraseña(String texto) {

        Pattern pattern = Pattern.compile("^(?=.\\d)(?=.[\\u0021-\\u002f\\u003a-\\u0040\\u005b-\\u005f])(?=.[A-Z])(?=.[a-z])\\S{8,}$");
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()){
            System.out.println("IP: " + matcher.group());
        }

    }

}
