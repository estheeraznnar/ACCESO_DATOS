import modelo.Estudiante;
import modelo.Profesor;
import modelo.ProfesorNombreComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Estudiante estudiante = new Estudiante(1, "Juan");
        Estudiante estudiante2 = new Estudiante(2, "Paco");
        Estudiante estudiante3 = new Estudiante(3, "Pepe");
        Estudiante estudiante4 = new Estudiante(4, "Marcos");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);
        estudiantes.add(estudiante4);

        //Lo ordena como esta en compareTo de estudiante
        Collections.sort(estudiantes);

        System.out.println(estudiantes);*/

        Profesor profesor = new Profesor(1, "Sara");
        Profesor profesor1 = new Profesor(2, "Paco");
        Profesor profesor2 = new Profesor(3, "Juan");
        Profesor profesor3 = new Profesor(4, "Jose");
        Profesor profesor4 = new Profesor(5, "Josa");

        //Lista ordenada por id
        //List<Profesor> profesores = new ArrayList<>(List.of(profesor, profesor1, profesor2, profesor3, profesor4));

        //Lista ordenada por nombre tal y como esta en la clase de ProfesorNombreComparator
        List<Profesor> profesores = new ArrayList<>(List.of(profesor, profesor1, profesor2, profesor3, profesor4));
        Collections.sort(profesores, new ProfesorNombreComparator());

        System.out.println(profesores);

    }
}