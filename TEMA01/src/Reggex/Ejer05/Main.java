package Reggex.Ejer05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*Extraer todas las palabras que empiezan con una letra mayúscula:
Descripción: Dado un texto, extraer todas las palabras que empiezan con una letra
mayúscula.*/
public class Main {
    public static void main(String[] args) {
        String mayusculas = "El proyecto comenzó el 01/01/2023 y se espera que la primera fase termine el 15/03/2024." +
                " Un hito clave se alcanzó el 20/07/2023." +
                " Se han realizado seguimientos adicionales el 10/11/2023 y el 05/01/2025.  ";

        //1 Extrar los Telefonos
        extraerMayusculas(mayusculas);
    }

    private static void extraerMayusculas(String mayusculas) {

        Pattern pattern = Pattern.compile("\\b[A-Z]\\w*\\b");
        Matcher matcher = pattern.matcher(mayusculas);
        while (matcher.find()){
            System.out.println("Palabra: " + matcher.group());
        }

    }
}
