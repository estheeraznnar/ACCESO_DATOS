package StreamBusquedas.Ejer01;

import StreamBusquedas.Ejer01.modelo.Frutas;

import java.util.Arrays;
import java.util.List;

/*Crea una clase Fruta con al menos dos atributos, nombre y color.
Crea una lista con diferentes frutas. Llámala frutería
Obtén una lista de Strings, que contenga el nombre de las frutas que contenía la frutería.*/
public class Main {

    public static void main(String[] args) {

        List<Frutas> fruteria = Arrays.asList(new Frutas("Manzana", "Roja"),
                new Frutas("Pera", "Verde"),
                new Frutas("Piña", "Amarilla"),
                new Frutas("Melocoton", "Naranja"),
                new Frutas("Cereza", "Granate"),
                new Frutas("Kiwi", "Verde"));

        System.out.println(fruteria);

        List<String> nombresFrutas = fruteria.stream().map(Frutas::getNombre).toList();
        System.out.println(nombresFrutas);

    }

}
