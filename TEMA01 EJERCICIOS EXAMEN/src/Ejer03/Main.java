package Ejer03;

import Ejer03.modelo.Persona;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setEdad(23);
        persona.setNombre("Juan");
        Persona persona2 = new Persona("Maria", 60);
        Persona persona3 = new Persona("Jose", 18);
        Persona persona4 = new Persona("Paco", 56);
        Persona persona5 = new Persona("Sara", 26);
        Persona persona6 = new Persona("German", 19);
        Persona persona7 = new Persona("Teresa", 89);
        Persona persona8 = new Persona("Raquel", 32);
        Persona persona9 = new Persona("Juan", 35);
        Persona persona10 = new Persona("Pedro", 15);

        List<Persona> personas = List.of(persona, persona2, persona3, persona4, persona5, persona6, persona7, persona8, persona9, persona10);

        //Calculo de la edad promedia
        double edadPromedia = personas.stream()
                .mapToInt(Persona::getEdad).average().orElse(0);
        System.out.println("Edad Promedia: " + edadPromedia);

        //Persona joven
        Persona personaMasJoven = personas.stream()
                .min((p1, p2) -> p1.getEdad() - p2.getEdad()).get();
        System.out.println("La persona mas joven es: " + personaMasJoven);

        //mayores 30
        List<String> personamayor30 = personas.stream()
                .filter(p -> p.getEdad() > 30).map(Persona::getNombre).toList();
        System.out.println(personamayor30);
    }

}
