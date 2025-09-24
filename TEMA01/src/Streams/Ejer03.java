package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*Transformar una lista de números: Crea una lista de números enteros. Utiliza una
“Function” para transformar cada número en la lista a su cubo.*/
public class Ejer03 {

    public static void main(String[] args) {
        Function<Integer, Integer> cubo = n -> n * n * n;

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
        List<Integer> cubos = numbers.stream().map(cubo).toList();
        System.out.println(cubos);

    }

}
