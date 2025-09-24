package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/*Aplicar una operación a cada elemento de una lista: Crea una lista de números
enteros. Utiliza un “Consumer” para aplicar una operación a cada número en la
lista (por ejemplo, multiplicar cada número por 2).*/
public class Ejer06 {

    public static void main(String[] args) {

        Consumer<Integer> multiplicaPor2 = n -> System.out.println(n*2);

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numeros.forEach(multiplicaPor2);

    }

}
