package Map;

import Map.modelo.Estudiante;

import java.util.*;

/*Dada una lista de estudiantes (donde cada estudiante es un objeto con
propiedades como nombre, edad, grado, etc.), escribir una función que devuelva
un Map donde las claves son los nombres de los estudiantes y los valores son los
objetos de los estudiantes.*/
public class Ejer03 {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Pepe", 1, "Garcia", "1ºC"));
        estudiantes.add(new Estudiante("Sara", 2, "Gonzales", "6ºB"));
        estudiantes.add(new Estudiante("Carolina", 3, "Suarez", "2ºC"));
        estudiantes.add(new Estudiante("Soriano", 4, "Peraz", "1ºC"));
        estudiantes.add(new Estudiante("Antonio", 5, "Socos", "Dam2"));
        estudiantes.add(new Estudiante("Lucas", 6, "Jimenez", "Dam1"));

        Map<String, Estudiante> mapaEstudiante = mapearEstudiantesporNombre(estudiantes);

        for (Map.Entry<String, Estudiante> entry : mapaEstudiante.entrySet()){
            System.out.println("Nombre=clave: " + entry.getKey() + "             Estudiante: " + entry.getValue());
        }

    }

    private static Map<String, Estudiante> mapearEstudiantesporNombre(List<Estudiante> estudiantes) {

        Map<String, Estudiante> mapaEstudiantes = new HashMap<>();

        for (Estudiante estudiante : estudiantes){

            mapaEstudiantes.put(estudiante.getNombre(), estudiante);

        }
        return mapaEstudiantes;

    }

}