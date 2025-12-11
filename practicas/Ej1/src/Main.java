import modelo.Empleado;

import java.io.*;
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

        try {
            List<Empleado> empleados = cargarEmpleados(inputfile);

            System.out.println("Todos empleados leidos: " + empleados.size());

            System.out.println("1- EMPLEADOS SIN ORDENAR");
            List<Empleado> empleados1 = empleados.stream()
                    .filter(e -> e.getEdad()>=20 && e.getEdad() <=40 && e.getSalario()>=5000)
                    .collect(Collectors.toList());
            System.out.println("Empleados filtrados sin ordenar: " + empleados1.size());
            empleados1.stream().forEach(System.out::println);

            System.out.println("2- EMPLEADOS FILTRADOS Y ORDENADOS POR SALARIO");
            List<Empleado> empleados2 = empleados.stream()
                            .filter(e -> e.getEdad()>=20 && e.getEdad()<=40 && e.getSalario()>=5000)
                            .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                            .collect(Collectors.toList());

            System.out.println("Empleados filtrados y ordenados: " + empleados2.size());
            empleados2.stream().forEach(System.out::println);

            //guardo los empleados
            guardarEmpleados(empleados2, outputfile);
            System.out.println("\n Proceso terminado");
            System.out.println("Archivo guardado en: " + outputfile);
        }catch (IOException e){
            System.err.println("Error al procesar archivos: " + e.getMessage());
            e.printStackTrace();
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

    private static void guardarEmpleados(List<Empleado> empleados2, String outputfile) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile))){
            bw.write("Nombre Apellido,Edad,Salario");
            bw.newLine();

            for (Empleado empleado: empleados2){
                bw.write(empleado.toFileFormat());
                bw.newLine();
            }
        }
    }

    private static List<Empleado> cargarEmpleados(String inputfile) throws IOException {
        List<Empleado> empleados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputfile))){
            String linea;
            boolean primeralinea = true;

            while ((linea = br.readLine()) != null){
                //Salto la linea del encabezdo
                if (primeralinea){
                    primeralinea = false;
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length == 3){
                    String nombreCompleto = datos[0].trim();
                    int edad = Integer.parseInt(datos[1].trim());
                    double salario = Double.parseDouble(datos[2].trim());

                    empleados.add(new Empleado(nombreCompleto, edad, salario));
                }
            }
        }
        return empleados;
    }


}