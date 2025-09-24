package StreamBusquedas.Ejer02;

import StreamBusquedas.Ejer01.modelo.Frutas;

import java.util.Arrays;
import java.util.List;

/*Utiliza la misma estructura del ejercicio 1, y ahora imprime por pantalla los colores de las
diferentes frutas. (No pueden aparecer colores repetidos.)*/
public class Main {

    public static void main(String[] args) {

        List<Frutas> fruteria = Arrays.asList(new Frutas("Manzana", "Roja"),
                new Frutas("Pera", "Verde"),
                new Frutas("Piña", "Amarilla"),
                new Frutas("Melocoton", "Naranja"),
                new Frutas("Cereza", "Granate"),
                new Frutas("Kiwi", "Verde"));

        System.out.println(fruteria);

        //Va delante map que distinct porque coje primero los colores y luego los distingue
        List<String> color = fruteria.stream().map(Frutas::getColor).distinct().toList();
        System.out.println(color);

    }

}
