package Ej01;

import Ej01.modelo.Producto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Ejer01 {

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
                raf.writeInt(producto.getId());
                raf.writeBytes(String.format("%-10s", producto.getNombre()));
                raf.writeDouble(producto.getPrecio());
                raf.writeBoolean(producto.isDescuento());
                raf.writeChar(producto.getTipo());
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
                int id = randomAccessFile.readInt();
                byte[] nombreEnBytes = new byte[10];
                randomAccessFile.readFully(nombreEnBytes);
                String nombre = new String(nombreEnBytes).trim();
                double precio = randomAccessFile.readDouble();
                boolean des = randomAccessFile.readBoolean();
                char tipo = randomAccessFile.readChar();
                Producto p = new Producto(id, nombre, precio, des, tipo);
                System.out.println(p);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}