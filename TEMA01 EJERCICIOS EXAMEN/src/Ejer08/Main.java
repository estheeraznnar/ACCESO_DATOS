package Ejer08;

import Ejer08.modelo.Cancion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Cancion> canciones = new ArrayList<>(
                Arrays.asList(
                        new Cancion("Livin' on Prayer", "Bon Jovi"),
                        new Cancion("Long Hot Summer", "Keith Urban"),
                        new Cancion("It's my Life", "Bon Jovi"),
                        new Cancion("Dolor Fantasma", "Amadeus"),
                        new Cancion("Run To You", "Bryan Adams"),
                        new Cancion("Summer of 69", "Bryn Adams"),
                        new Cancion("Paranoid", "Black Sabbath"),
                        new Cancion("Cherokee", "Europe"),
                        new Cancion("River Bank", "Brad Paisley")
                ));

        filtrarConBucles(canciones, "Bon Jovi");
        System.out.println("----------");
        Filtradofuncional( canciones, "Bon Jovi");
        System.out.println("-----------");
        FiltradofuncionalANuevaLista( canciones, "Bon Jovi");
        System.out.println("-----------");
        numeroCancionDeCantante(canciones, "Bon Jovi");
        System.out.println("-----------");
        CancionesPorCantante(canciones);
        System.out.println("-----------");
        sinDuplicado(canciones);


    }

    private static void sinDuplicado(List<Cancion> canciones) {
        canciones.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void CancionesPorCantante(List<Cancion> canciones) {
        canciones.stream().collect(Collectors.groupingBy(Cancion::getCantante, Collectors.counting()))
                .forEach((cantante, numero)-> System.out.println("Cantante: " + cantante + " tiene: " + numero + " canciones"));
    }

    private static void numeroCancionDeCantante(List<Cancion> canciones, String cantante) {
        long numeroCanciones = canciones.stream()
                .filter(cancion -> cancion.getCantante().equals(cantante))
                .count();
        System.out.println("El cantante: " + cantante + " tiene " + numeroCanciones + " numero de canciones");
    }

    private static void filtrarConBucles(List<Cancion> canciones, String cantante){
        List<Cancion> listFiltrada = new LinkedList<>();
        for (Cancion cancion: canciones){
            if (cancion.getCantante().equals("Bon Jovi"))
                listFiltrada.add(cancion);
        }
        for (Cancion c: listFiltrada){
            System.out.println(c.toString());
        }
    }

    private static void Filtradofuncional(List<Cancion> canciones, String cantante){
        System.out.println("Funcional: ");
        canciones.stream().filter(c-> c.getCantante().equals(cantante)).forEach(System.out::println);
    }

    private static void FiltradofuncionalANuevaLista(List<Cancion> canciones, String cantante) {
        System.out.println("Funcional a una nueva lista: ");
        List<Cancion> cancionList = canciones.stream()
                .filter(c-> c.getCantante().equals(cantante)).toList();

        for (Cancion c: cancionList){
            System.out.println(c);
        }
    }

}
