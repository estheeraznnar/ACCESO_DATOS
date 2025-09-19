package TEMA01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//UD01--Lamnda
public class StringsLongitud {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Perro", "Gato", "Elefante", "Conejo", "Mariposa");
        //Compaa longitudes
        Collections.sort(list, (String string1, String string2) -> string1.length() - string2.length());

        System.out.println(list);

    }

}