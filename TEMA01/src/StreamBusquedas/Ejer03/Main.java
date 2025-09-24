package StreamBusquedas.Ejer03;

import java.util.Arrays;
import java.util.List;

/*Crea una lista de números.
Usando stream, calcula la suma de los cuadrados de todos los números de la lista.*/
public class Main {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7);
        int sumaCuadrados = numeros.stream().map(n -> n * n).reduce(0, Integer::sum);

        System.out.println(sumaCuadrados);
    }

}
