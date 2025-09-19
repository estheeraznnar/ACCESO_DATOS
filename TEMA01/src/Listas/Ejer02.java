package Listas;

import java.util.ArrayList;
import java.util.List;

public class Ejer02 {

    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);

        List<Integer> listaPares = obtenerNumerosPares( lista);
        System.out.println(listaPares);
    }

    private static List<Integer> obtenerNumerosPares(List<Integer> lista) {
        List<Integer> listaPares = new ArrayList<>();
        for (Integer num : lista) {
            if (num % 2 == 0) {
                listaPares.add(num);
            }
        }
        return listaPares;
    }


}
