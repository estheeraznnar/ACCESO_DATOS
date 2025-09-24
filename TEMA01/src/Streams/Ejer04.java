package Streams;

import java.util.Random;
import java.util.function.Supplier;

/*Generar una secuencia de números aleatorios: Utiliza un “Supplier” para generar e
imprimir una secuencia de diez números aleatorios.*/
public class Ejer04 {

    public static void main(String[] args) {

        Supplier<Integer> aleatorio = () -> new Random().nextInt(10);

        for (int i = 0; i < 10; i++) {
            System.out.println(aleatorio.get());
        }

    }

}
