import modelo.Empleado;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<Empleado> employees = Arrays.asList(
                new Empleado("Alice", new ArrayList<>(Arrays.asList("Project1", "Project2")), new ArrayList<>(Arrays.asList("Java", "Spring")), 35, 60000),
                new Empleado("Bob", new ArrayList<>(Arrays.asList("Project3")), new ArrayList<>(Arrays.asList("JavaScript", "React")), 28, 45000),
                new Empleado("Charlie", new ArrayList<>(Arrays.asList("Project1", "Project4")), new ArrayList<>(Arrays.asList("Java", "Angular")), 40, 70000),
                new Empleado("David", new ArrayList<>(Arrays.asList("Project2", "Project3", "Project5")), new ArrayList<>(Arrays.asList("Python", "Django")), 32, 80000),
                new Empleado("Eve", new ArrayList<>(Arrays.asList("Project5")), new ArrayList<>(Arrays.asList("Java", "Spring", "Hibernate")), 25, 50000),
                new Empleado("Frank", new ArrayList<>(Arrays.asList("Project1", "Project3")), new ArrayList<>(Arrays.asList("Java", "Spring")), 35, 90000),
                new Empleado("Grace", new ArrayList<>(Arrays.asList("Project2", "Project4")), new ArrayList<>(Arrays.asList("Java", "Spring")), 35, 80000),
                new Empleado("Heidi", new ArrayList<>(Arrays.asList("Project1", "Project3")), new ArrayList<>(Arrays.asList("Java", "Spring")), 35, 38000)
        );


        //1 - Muestra los empleados mayores de 30 años que tengan un salario superior a 50.000.

        List<Empleado> ejercicio1= employees.stream().filter(emp -> emp.getEdad()>=30 && emp.getSalario()>=50000)
                .collect(Collectors.toList());

        System.out.println("\n 1- EMPLEADOS MAYORES DE 30 Y SALARIO MAYOR DE 50.000");
        ejercicio1.forEach(System.out::println);



        //2 - Muestra los empleados agrupados a los empleados según el número de proyectos en los que participan.
        System.out.println("\n EMPLEADOS AGRUPADOS POR PROYECTOS");

        Map<Integer, List<Empleado>> empPorNumProyecto = employees.stream()
                .collect(Collectors.groupingBy(empleado -> empleado.getProyectos().size()));

        empPorNumProyecto.forEach((proyecto, empleados) -> {
            System.out.println("Empleados del proyecto " + proyecto + " son: ");
            empleados.forEach(empleado -> System.out.println(" - " + empleado));
        });

        //3 - Indica el número de empleados que poseen cada habilidad.

        System.out.println("\n CARGADOR DE HABILIDADES");
        Map<String, Long> empleadosPorHabilidad = employees.stream()
                .flatMap(empleado -> empleado.getHabilidades().stream())
                .collect(Collectors.groupingBy(
                        habilidad ->habilidad,
                        Collectors.counting()
                ));

        empleadosPorHabilidad.forEach((habilidad, numEmpleado) -> {
            System.out.print(habilidad + ": " + numEmpleado);
            System.out.println();
        });

        //4 - Ordenar a los empleados por su salario en orden descendente.

        System.out.println("\n EMPLEADOS ORDENADOS POR SALARIO");
        List<Empleado> ejer4 = employees.stream()
                .sorted(Comparator.comparing(Empleado::getSalario).reversed())
                .collect(Collectors.toList());
        ejer4.forEach(System.out::println);

        //5 - Encuentra al empleado con el salario más alto.

        System.out.println("\n EMPLEADO CON SALARIO MAS ALTO");
        Optional<Empleado> empleadoMasSalario =employees.stream()
                .max(Comparator.comparing(Empleado::getSalario));
        empleadoMasSalario.ifPresent(empleado ->
                System.out.println(empleado));

        //6 - Encuentra al empleado con el salario más bajo que tenga más de 30 años.

        System.out.println("\n EMPLEADO MAYOR DE 30 CON EL SALARIO MAS BAJO");
        Optional<Empleado> ejercicio6 = employees.stream()
                .filter(empleado -> empleado.getEdad()>=30)
                .min(Comparator.comparingDouble(Empleado::getSalario));
        ejercicio6.ifPresent(empleado -> System.out.println(empleado));

        //7 - Encuentra al empleado con el salario más alto que tenga menos de 30 años y que participe en más de un proyecto.

        System.out.println("\n EMPLEADO MENOR DE 30 CON MAS DE UN PROYECTO Y EL SALARIO MAS ALTO");
        Optional<Empleado> ejercicio7 = employees.stream()
                .filter(empleado -> empleado.getEdad()<30)
                .filter(empleado -> empleado.getProyectos().size()>1)
                .max(Comparator.comparingDouble(Empleado::getSalario));
        ejercicio7.ifPresent(empleado -> System.out.println(empleado));

    }

}