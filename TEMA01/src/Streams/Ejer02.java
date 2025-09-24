package Streams;

import java.util.List;
import java.util.function.Consumer;

/*Imprimir todos los elementos de una lista: Crea una lista de cadenas. Utiliza un
“Consumer” para imprimir cada cadena en la lista.*/
public class Ejer02 {

    //ECHO POR JUANMA
    public static void main(String[] args) {

        Consumer<String> impCadena =  s -> System.out.println(s);
        List<String> cadenas = List.of("Esther", "Raquel", "German", "Javier");

        cadenas.forEach(impCadena);
    }


    //ECHO POR MI
    /*public static void main(String[] args) {

        List<String> cadenas = List.of("Esther", "Raquel", "German", "Javier");

        //Consumer: Imprime cada cadena
        Consumer<String> impCadena = cadena -> System.out.println(cadena);

        cadenas.forEach(impCadena);
    }*/

}
