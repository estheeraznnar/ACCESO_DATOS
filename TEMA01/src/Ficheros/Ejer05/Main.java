package Ficheros.Ejer05;

import Ficheros.Ejer05.modelo.Producto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/*Crea una clase Producto con los siguientes atributos:
private int id;
private String nombre;
private double precio;
private boolean descuento;
private char tipo;
Crea un programa que cree 5 productos, los meta en un ArrayList. Ahora recorra el
arrayList y que guarde los productos en un fichero de acceso aleatorio.
Ahora debes de leer y mostrar por consola el contenido del fichero.
Ahora debes de ser capaz de mostar por consola el cuarto producto que hay en el fichero.*/
public class Main {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto1", 10.0, true, 'A'));
        productos.add(new Producto(2, "Producto2", 20.0, true, 'A'));
        productos.add(new Producto(3, "Producto3", 30.0, true, 'A'));
        productos.add(new Producto(4, "Producto4", 40.0, true, 'A'));
        productos.add(new Producto(5, "Producto5", 50.0, true, 'A'));

        String filePath = "productos.data";

        //Escribir los productos
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {

            for (Producto producto: productos){
                raf.writeUTF(producto.toString());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //leer y mostrar
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r")){

            randomAccessFile.seek(0);
            while (randomAccessFile.getFilePointer() < randomAccessFile.length()){
                System.out.println(randomAccessFile.readUTF());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Si me pidiera el 4 unicamente
        System.out.println("mostrar el cuarto elemento");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r")){

            randomAccessFile.seek(0);
            for (int i = 0; i < 3; i++) {
                randomAccessFile.readUTF(); //me salto los tres primeros
            }
            System.out.println("El cuarto es: " + randomAccessFile.readUTF());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
