package Ejer09;

import Ejer09.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Alumno> listaAlumnos = new ArrayList<>();
        // Cargamos la lista de Alumnos
        listaAlumnos.add(new Alumno(1, "1717213183", "Javier", "Molina Cano", "Java 8", 7, 28));
        listaAlumnos.add(new Alumno(2, "1717456218", "Ana", "Gómez Álvarez", "Java 8", 10, 33));
        listaAlumnos.add(new Alumno(3, "1717328901", "Pedro", "Marín López", "Java 8", 8.6, 15));
        listaAlumnos.add(new Alumno(4, "1717567128", "Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        listaAlumnos.add(new Alumno(5, "1717902145", "Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        listaAlumnos.add(new Alumno(6, "1717678456", "Germán", "López Fernández", "Java 8", 8, 34));
        listaAlumnos.add(new Alumno(7, "1102156732", "Oscar", "Murillo González", "Java 8", 10, 32));
        listaAlumnos.add(new Alumno(8, "1103421907", "Antonio Jesús", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new Alumno(9, "1717297015", "César", "González Martínez", "Java 8", 8, 26));
        listaAlumnos.add(new Alumno(10, "1717912056", "Gloria", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new Alumno(11, "1717912058", "Jorge", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new Alumno(12, "1717912985", "Ignacio", "Duque García", "Java Script", 9.4, 32));
        listaAlumnos.add(new Alumno(13, "1717913851", "Julio", "González Castaño", "C Sharp", 10, 22));
        listaAlumnos.add(new Alumno(14, "1717986531", "Gloria", "Rodas Carretero", "Ruby", 7, 18));
        listaAlumnos.add(new Alumno(15, "1717975232", "Jaime", "Jiménez Gómez", "Java Script", 10, 18));

        //Muestra todos los alumnos: Lista de Alumnos🡪 debes usar una referencia a metodo.
        System.out.println("--------- 1");
        listaAlumnos.stream().forEach(System.out::println);

        //Alumnos cuyo apellido empiezan con el caracter L u G
        System.out.println("------------------------- 2");
        listaAlumnos.stream()
                .filter(a-> a.getApellidos().startsWith("L")|| a.getApellidos().startsWith("G")) //<- Asi o asi: a-> a.getApellidos().charAt(0) == 'L' || a.getApellidos().charAt(0) == 'G'
                .forEach(System.out::println);

        //Número de Alumnos
        System.out.println("---------------- 3");
        System.out.println(listaAlumnos.stream().count());

        //Alumnos con nota mayor a 9 y que sean del curso PHP
        System.out.println("---------------------------- 4");
        listaAlumnos.stream()
                .filter(a-> a.getNota()>9 && a.getNombreCurso().equals("PHP"))
                .forEach(System.out::println);

        //Imprimir los 2 primeros Alumnos de la lista
        System.out.println("--------------------- 5");
        listaAlumnos.stream().limit(2)
                .forEach(System.out::println);

        //Imprimir el alumno con menor edad
        System.out.println("---------------- 6");
        listaAlumnos.stream().min((a1, a2) -> a1.getEdad()-a2.getEdad())
                .ifPresent(System.out::println);

        //Imprimir el alumno con mayor edad
        System.out.println("------------ 7");
        listaAlumnos.stream().max((a1, a2) -> a1.getEdad()-a2.getEdad())
                .ifPresent(System.out::println);

        //Encontrar el primer Alumno
        System.out.println("--------- 8");
        listaAlumnos.stream().limit(1)
                .forEach(System.out::println);
            //Tambien se puede asi
        listaAlumnos.stream().findFirst().ifPresent(System.out::println);

        //Alumnos que tienen un curso en el que el nombre contienen la A
        System.out.println("--------- 9");
        listaAlumnos.stream()
                .filter(a-> a.getNombreCurso().contains("a"))
                .forEach(System.out::println);

        //Alumnos en que la longitud de su nombre es mayor a 10 caracteres
        System.out.println("----------- 10");
        listaAlumnos.stream()
                .filter(a-> a.getNombre().length() > 10)
                .forEach(System.out::println);

        //Obtiene los alumnos en los cuales el nombre del curso empieza con el caracter 'P' y la longitud sea <= a 6
        System.out.println("---------- 11");
        listaAlumnos.stream()
                .filter(a -> a.getNombreCurso().startsWith("P") && a.getNombreCurso().length()<=6)
                .forEach(System.out::println);

        //Crea una nueva lista llamada “listaNueva” con el contenido de la consulta anterior.
        System.out.println("---------- 12");
        List<Alumno> nuevaLista = listaAlumnos.stream()
                .filter(a -> a.getNombreCurso().startsWith("P") && a.getNombreCurso().length()<=6)
                .toList();
        nuevaLista.stream().forEach(System.out::println);
    }
}
