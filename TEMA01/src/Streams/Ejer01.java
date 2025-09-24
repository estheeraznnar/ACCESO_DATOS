package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*Filtrar números impares: Crea una lista de números enteros. Utiliza un “Predicate”
para filtrar la lista y eliminar todos los números impares.*/
public class Ejer01 {
    //ECHO POR JUANMA
    // 1) Filtro numeros impares: Crea una lista de numeros enteros. Utiliza un Predicate

    public static void main(String[] args) {

        Predicate<Integer> isOdd = n -> n % 2 != 0;

        List<Integer> numero = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
        numero.removeIf(isOdd);
        System.out.println(numero);

    }

    //ECHO POR MI

    /*public static void main(String[] args) {

        List<Integer> numero = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numero.add(i);
        }

        //El predicare: elimina si el numero es impar
        numero.removeIf(n -> n % 2 != 0);

        System.out.println(numero);

    }*/

}
