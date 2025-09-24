package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*Filtrar nombres que comienzan con una letra específica: Crea una lista de
nombres. Utiliza un “Predicate” para filtrar la lista y mantener solo los nombres
que comienzan con una letra específica (por ejemplo, "A").*/
public class Ejer05 {

    public static void main(String[] args) {

        Predicate<String> comienzaPorA = s -> s.startsWith("A");
        List<String> nom = new ArrayList<>(List.of("Esther", "PAco", "Josefa", "Carlos", "German", "Samuel", "Alba"));
        nom.removeIf(comienzaPorA.negate());
        System.out.println(nom);

    }

}
