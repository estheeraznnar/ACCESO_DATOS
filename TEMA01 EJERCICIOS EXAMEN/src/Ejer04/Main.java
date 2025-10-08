package Ejer04;

import Ejer04.modelo.Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*Lee un archivo CSV con datos de productos (nombre, precio, categoría) utiliza el contenido
leído para inicializar un arraylist:
• Calcula el producto más caro de cada categoría.
• Imprime una lista con los productos cuyo precio está entre 10 y 20 euros.*/
public class Main {

    public static void main(String[] args) {

        //Leer
        List<Producto> listaProducto = leerProductos("Ej4.csv");
        //Calcular el producto mas caro
        listaProducto.stream().collect(Collectors.groupingBy(Producto::getCategoria,
                Collectors.maxBy(Comparator.comparing(Producto::getPrecio))))
                .forEach((categoria, producto) -> System.out.println(
                        "Producto mas caro de la categoria: " + categoria +
                                ": " + producto.orElse(null)));

        //Lista productos con precio entre 10 y 20
        List<Producto> listaEntre10y20 = listaProducto.stream()
                .filter(p->p.getPrecio() >= 10 && p.getPrecio()<=20).toList();
        System.out.println("Entre 10 y 20: " );

    }

    private static List<Producto> leerProductos(String nombreFichero) {

        List<Producto> productoList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))){

            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null){
                String[] campos = linea.split(";");
                String nombre = campos[0];
                double precio = Double.parseDouble(campos[1].replace(",", ";"));
                String categoria = campos[2];
                Producto producto = new Producto(nombre, precio, categoria);
                productoList.add(producto);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return productoList;
    }


}
