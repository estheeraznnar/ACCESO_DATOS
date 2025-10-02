package Reggex.Ejer03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Extraer todas las fechas en formato DD/MM/YYYY:
Descripción: Dado un texto, extraer todas las fechas en el formato DD/MM/YYYY.*/
public class Main {

    public static void main(String[] args) {
        String fechas = "El proyecto comenzó el 01/01/2023 y se espera que la primera fase termine el 15/03/2024. Un hito clave se alcanzó el 20/07/2023. Se han realizado seguimientos adicionales el 10/11/2023 y el 05/01/2025.  ";

        //1 Extrar los Telefonos
        extraerFechas(fechas);
    }

    private static void extraerFechas(String fechas) {

        Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher = pattern.matcher(fechas);
        while (matcher.find()){
            System.out.println("Fecha: " + matcher.group());
        }

    }

}
