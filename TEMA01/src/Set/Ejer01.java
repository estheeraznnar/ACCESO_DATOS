package Set;

import java.util.HashSet;
import java.util.Set;

/*Crear un Set de Strings y añadir elementos a él. Luego, imprimir todos los
elementos del Set. ¿Qué observas acerca del orden de los elementos?*/
public class Ejer01 {

    public static void main(String[] args) {

        Set<String> conjunto = new HashSet<>();

        conjunto.add("Hola");
        conjunto.add("Adios");
        conjunto.add("Jose");
        conjunto.add("Paco");
        conjunto.add("Pedro");
        conjunto.add("SAlir");
        conjunto.add("Solo");
        conjunto.add("Paco");

        for (String str : conjunto){
            System.out.println(str);
        }

        System.out.println("\n -----------------");
        System.out.println(conjunto);

    }

}
