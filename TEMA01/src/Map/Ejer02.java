package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Dada una lista de Strings, escribir una función que devuelva un Map donde
las claves son los Strings únicos de la lista y los valores son el número de veces
que cada String aparece en la lista.*/
public class Ejer02 {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("Hola");
        lista.add("que");
        lista.add("mundo");
        lista.add("java");
        lista.add("java");
        lista.add("java");
        lista.add("mundo");
        lista.add("que");
        lista.add("Haces");

        Map<String, Integer> frecuencia = contarFrecuenciaStrings(lista);

        for (Map.Entry<String, Integer> entry:frecuencia.entrySet()){
            System.out.println("String: " + entry.getKey() + "    frecuencia: " + entry.getValue());
        }

    }

    private static Map<String, Integer> contarFrecuenciaStrings(List<String> lista) {

        Map<String, Integer> frecuenciaMap = new HashMap<>();
        for (String string : lista){
            frecuenciaMap.put(string, frecuenciaMap.getOrDefault(string, 0) +1);
        }

        return frecuenciaMap;
    }

}