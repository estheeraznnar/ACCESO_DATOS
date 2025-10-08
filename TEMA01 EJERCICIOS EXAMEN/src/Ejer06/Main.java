package Ejer06;

import Ejer06.modelo.Coche;
import Ejer06.modelo.Persona;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Coche coche = new Coche("Seat", "Rojo", "1565AFB");
        Coche coche2 = new Coche("Ford", "Azul", "1565AFB");
        Coche coche3 = new Coche("Renoult", "Verde", "1565AFB");
        Coche coche4 = new Coche("Seat", "Gris", "1565AFB");
        Coche coche5 = new Coche("Fiat", "Amarillo", "1565AFB");
        Coche coche6 = new Coche("Opel", "Blanco", "1565AFB");
        Coche coche7 = new Coche("Citroen", "Rojo", "1565AFB");
        Coche coche8 = new Coche("Peugeot", "Azul", "1565AFB");
        Coche coche9 = new Coche("Mercedes", "Negro", "1565AFB");
        Coche coche10 = new Coche("Opel", "Negro", "1565AFB");
        Coche coche11 = new Coche("Audi", "Blanco", "1565AFB");
        Coche coche12 = new Coche("BMW", "Amarillo", "1565AFB");
        Coche coche13 = new Coche("Toyota", "Azul", "1565AFB");
        Coche coche14 = new Coche("Omoda", "Verde", "1565AFB");
        Coche coche15 = new Coche("Ebro", "Azul", "1565AFB");
        Coche coche16 = new Coche("Dr", "Azul", "1565AFB");

        Persona persona = new Persona("Juan", "12345678A", List.of(coche, coche2, coche3));
        Persona persona2 = new Persona("Maria", "12345678A", List.of(coche4, coche5, coche6));
        Persona persona3 = new Persona("Antonio", "12345678A", List.of(coche7, coche8, coche9));
        Persona persona4 = new Persona("Pedro", "12345678A", List.of(coche10, coche11, coche12));
        Persona persona5 = new Persona("German", "12345678A", List.of(coche13, coche14, coche15, coche16));

        List<Persona> personas = List.of(persona, persona2, persona3, persona4, persona5);
        List<Persona> personasCocheRojo = personas.stream()
                .filter(p -> p.getListaCoches().stream()
                    .anyMatch(c-> "Rojo".equals(c.getColor()))).toList();
        System.out.println(personasCocheRojo);
        System.out.println("------------------------");

        //Personas Opel
        List<Persona> personasOpel = personas.stream()
                .filter(p->p.getListaCoches().stream()
                        .anyMatch(coche1 -> "Opel".equals(coche1.getMarca())))
                .toList();
        System.out.println(personasOpel);

        System.out.println("----------------------");
        //Encontrar personas mas coches
        Persona personaMasCoches = personas.stream()
                .max((p1, p2)-> p1.getListaCoches().size() - p2.getListaCoches().size())
                .orElse(null);
        System.out.println(personaMasCoches);
    }
}
