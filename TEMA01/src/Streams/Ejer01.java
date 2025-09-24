package Streams;

import java.util.ArrayList;
import java.util.List;

/*Filtrar números impares: Crea una lista de números enteros. Utiliza un “Predicate”
para filtrar la lista y eliminar todos los números impares.*/
public class Ejer01 {

    public static void main(String[] args) {

        List<Integer> numero = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numero.add(i);
        }

        //El predicare: elimina si el numero es impar
        numero.removeIf(n -> n % 2 != 0);

        System.out.println(numero);

    }

}
