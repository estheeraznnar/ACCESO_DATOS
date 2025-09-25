package StreamBusquedas.Ejer05;

import StreamBusquedas.Ejer05.modelo.Empleado;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*Crea la clase empleado con al menos los atributos: nombre, departamento.
- Crea varios empleados y agrupar la lista de empleados por departamento.
- Agrupamos los empleados por departamento y contamos cuantos empleados hay en
cada departamento.
- Dado un departamento mostraremos sus empleados. Por ejemplo, muestra los
empleados de ventas.
- Dado un nombre de empleado, mostraremos su departamento.*/
public class Main {

    public static void main(String[] args) {

        List<Empleado> empleados = List.of(new Empleado("Paco", "Ventaas"),
                new Empleado("Maria", "Sistemas"),
                new Empleado("Pedro", "Ventaas"),
                new Empleado("Sara", "Gestion"),
                new Empleado("German", "Transporte"),
                new Empleado("Luis", "Sistemas"),
                new Empleado("Ana", "Ventaas"),
                new Empleado("Jose", "Gestion"),
                new Empleado("Andres", "Desarrollo"));

        //ECHO POR MI
        //Agrupamos los empleados por departamento
        Map<String, List<Empleado>> empleadosPorDep = empleados
                .stream().collect(Collectors
                        .groupingBy(Empleado::getDepartamento));

        System.out.println("Los empleados agrupados por departamentos son: ");
        empleadosPorDep.forEach((dep, lista) -> System.out.println(dep + ": " + lista));

        //Contar empleados por departameto
        Map<String, Long> contarDep = empleados.stream()
                .collect(Collectors
                        .groupingBy(Empleado::getDepartamento, Collectors.counting()));
        System.out.println("\n Cantidad de empleados por departameto: ");
        contarDep.forEach((dep, cantidad) -> System.out.println(dep + ": " + cantidad));

        //Mostrar empleados de ventas
        String depConsulta = "Ventaas";
        System.out.println("\nEmpleados del departamento " + depConsulta + ":");
        empleadosPorDep.getOrDefault(depConsulta, Collections.emptyList())
                .forEach(emp -> System.out.println(emp.getNombre()));

        /*HECHO POR MI
        //Dado un nombre muesta el departamento
        String  nomConsulta = "Paco";
        Optional<Empleado> buscar = empleados.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nomConsulta))
                .findFirst();
        if (buscar.isEmpty()){
            System.out.println("\n" + nomConsulta + " trabaja en " + buscar.get().getDepartamento());
        }else {
            System.out.println("\nEmpleado no encontrado");
        }*/

        System.out.println("---------------");
        //HECHO POR JUANMA
        String nomCon = "Paco";
        empleados.stream().filter(empleado -> empleado.getNombre().equals(nomCon))
                .map(Empleado::getDepartamento).forEach(System.out::println);

    }

}
