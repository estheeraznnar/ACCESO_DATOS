package Lambda;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Filtrado de lista con funciones lambda: Crea una lista de Strings que contenga varios
nombres. Luego, utiliza una función lambda para filtrar esta lista y crear una nueva lista
que solo contenga los nombres que comienzan con una letra específica (por ejemplo,
"A"). Para hacer esto, puedes utilizar el metodo “removeIf()” de “ArrayList”, que toma un
“Predicate” (que es una interfaz funcional que puedes implementar con una función
lambda).*/
public class MainEjer02 {

    public static void main(String[] args) {

        List<String> nom = new ArrayList<>(List.of("Esther", "Paco", "Josefa", "Carlos", "German", "Samuel"));
        //nom.removeIf();

    }

}
