package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Dada una lista de números enteros, escribir una función que devuelva un
Set que contenga solo los números únicos de la lista original.*/
public class Ejer02 {

    public static void main(String[] args) {

        List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(1);
        listaEnteros.add(2);
        listaEnteros.add(3);
        listaEnteros.add(4);
        listaEnteros.add(4);
        listaEnteros.add(5);
        listaEnteros.add(6);
        listaEnteros.add(91);
        listaEnteros.add(256);
        listaEnteros.add(1);
        listaEnteros.add(1);
        listaEnteros.add(1);
        listaEnteros.add(156);
        listaEnteros.add(91);

        Set<Integer> conjuntoUnico = obtenerNumerosUnicos(listaEnteros);
        System.out.println(conjuntoUnico);

    }

    private static Set<Integer> obtenerNumerosUnicos(List<Integer> listaEnteros) {

        return new HashSet<>(listaEnteros);

    }

}
