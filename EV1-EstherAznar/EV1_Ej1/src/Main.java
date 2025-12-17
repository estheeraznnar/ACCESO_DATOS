import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Peticion de numeros utilizando streams en java
Escribe un programa en java que realice las siguientes tareas:
-CRear una lista de numeros enteros que contenga los valores del 1 al 10.
-utiliza el Api streams de java para patricionar esta lista en dos grupos:
    *un grupo que contenga los numero pares
    *un grupo que contenga los numeros impares
-imprime el resultado en la consola mostrando la particion realizada
List<Integuer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

Ejemplo de ejecucion:
Partioned:{false=[1,3,5,7,9], true[2,4,6,8,10]}
 */

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Lista original sin separar por pares e impares: " + numbers);

        Map<Boolean, List<Integer>> particiones = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n%2 == 0));

        List<Integer> pares = particiones.get(true);
        List<Integer> impares = particiones.get(false);

        System.out.println("\nNumeros pares: " + pares);
        System.out.println("Numeros impares: " + impares);
    }
}