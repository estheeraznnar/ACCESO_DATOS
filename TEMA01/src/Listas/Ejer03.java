package Listas;

import java.util.ArrayList;
import java.util.List;

public class Ejer03 {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("Hola");
        lista.add("mundo");
        lista.add("prog");
        lista.add("efn");
        lista.add("Juan");
        lista.add("pero");
        lista.add("prefiero");
        lista.add("Python");

        int maxLong = longitudStringMasLargo(lista);

        System.out.println("El mas largo mide: " + maxLong);

    }

    private static int longitudStringMasLargo(List<String> lista) {
        int maxLength = 0;
        for (String str : lista){
            if (str.length()>maxLength){
                maxLength= str.length();
            }
        }
        return maxLength;
    }

}
