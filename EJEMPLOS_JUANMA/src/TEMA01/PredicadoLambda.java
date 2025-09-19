package TEMA01;

import java.util.Arrays;
import java.util.List;

//UD01-Landa y Filtro (Numeros)
public class PredicadoLambda {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //List<Integer> pares = numbers.stream().filter(n -> n % 2 == 0).toList();//toList para que sea una interaccion funcional
        List<Integer> pares = numbers.stream().filter(n -> n % 2 == 0)
                .map(n -> n * n).toList();

        System.out.println(pares);
        //pares.forEach(System.out::println);

    }

}
