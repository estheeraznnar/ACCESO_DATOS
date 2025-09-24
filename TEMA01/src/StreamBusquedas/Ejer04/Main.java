package StreamBusquedas.Ejer04;

import StreamBusquedas.Ejer04.modelo.Persona;

import java.util.List;

/*Crea la clase persona con al menos los atributos nombre y edad.
- Ordenar una lista de personas por edad de forma descendente
- Imprimimos la lista de las personas ordenada por nombre de forma ascendiente*/
public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Pepe", 25);
        Persona persona2 = new Persona("Paco", 30);
        Persona persona3 = new Persona("Pepe", 20);
        Persona persona4 = new Persona("Josefa", 28);
        Persona persona5 = new Persona("German", 19);
        Persona persona6 = new Persona("Pepa", 80);
        Persona persona7 = new Persona("Raquel", 38);
        Persona persona8 = new Persona("Eustaquia", 98);

        List<Persona> personas = List.of(persona1, persona2, persona3, persona4, persona5, persona6, persona7, persona8);
        personas.stream()
                .sorted((p1, p2)-> p2.getEdad() - p1.getEdad())
                .forEach(System.out::println);

        System.out.println("---------------------");

        personas.stream().sorted((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()))
                .forEach(System.out::println);
    }

}
