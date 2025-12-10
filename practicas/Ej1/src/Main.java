import modelo.Empleado;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {



        String inputfile = "employees.txt";
        String outputfile = "filtered_employes.txt";
        int min_edad = 20;
        int max_edad = 40;
        double min_salario = 50000;

        try {
            List<Empleado> empleados = cargarEmpleados(inputfile);

            System.out.println("1");
            List<Empleado> empleados1 = empleados.stream().filter(e -> e.getEdad()>=min_edad && e.getEdad() <= max_edad && e.getSalario()>=min_salario)
                    .toList();

            empleados1.sou
        }

        /*try{
            //Leo el archivo
            List<String> lineas = Files.readAllLines(Paths.get("./employees.txt"));

            //convierto cada linea a un objeto
            List<Empleado> empleados = lineas.stream()
                    .filter(linea -> linea.trim().isEmpty())
                    .map(linea -> {
                        String[] partes = linea.trim().split(" ,");

                        try {
                            return new Empleado(
                                    partes[0].trim(),
                                    partes[1].trim(),
                                    Integer.parseInt(partes[2].trim()),
                                    Double.parseDouble(partes[3].trim())
                            );
                        } catch (NumberFormatException e) {
                            throw new RuntimeException(e);
                        }
                    })

                    .collect(Collectors.toList());

            System.out.println(empleados);

            // Filtrar los empleados cuya edad esten entre 20 y 40 y cuyo salario sea mayor o igual a 50000
            List<Empleado> empleadoFiltrado = empleados.stream().filter(empleado -> empleado.getEdad()>20 && empleado.getEdad()<40) //Mayor de 20 y menor de 40
                    .filter(empleado -> empleado.getSalario()>=50000) //salario mayor de 50000
                    .collect(Collectors.toList());
            //Muestro el resultado
            System.out.println("-Empleados filtrados");
            empleadoFiltrado.forEach(System.out::println);
            System.out.println("\n Total filtrados: " + empleadoFiltrado.size());


            // Ordena los empleados filtrados por salario de manera descendemte
            List<Empleado> empleadoOrdenado = empleados.stream().filter(empleado -> empleado.getEdad()>20 && empleado.getEdad()<40) //Mayor de 20 y menor de 40
                    .filter(empleado -> empleado.getSalario()>=50000) //salario mayor de 50000
                    .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                    .collect(Collectors.toList());
            //Muestro el resultado
            System.out.println("-Empleados ordenado");
            empleadoOrdenado.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }

    private static List<Empleado> cargarEmpleados(String inputfile) throws IOException {
        Path path = Paths.get(inputfile);
        List<Empleado> empleados = new ArrayList<>();
        Stream<String> lines = Files.lines(path);

        lines.forEach(line -> {
            empleados.add(parsearEmpleado(line));

        });

        return null;


        //Me lee las listas del path
        /*return Files.lines(path)
                .map(String::trim)
                .filter(linea ->!linea.isEmpty())
                .map(Main::parsearEmpleado(linea))
                .filter(Objects::nonNull)   //Filtra cualquier linea mal formada
                .toList();*/
    }

    private static Empleado parsearEmpleado(String linea) {
        try {

            String[] datos = linea.split(",");

            if (datos.length < 3){
                return null;
            }

            String nombreCompleto = datos[0].trim();
            int edad = Integer.parseInt(datos[1].trim());
            double salario = Double.parseDouble(datos[2].trim());
            return new Empleado(nombreCompleto, edad, salario);

        }catch (Exception e){
            System.err.println("formato no valido");
        }
        return null;
    }
}