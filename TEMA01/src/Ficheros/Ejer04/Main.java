package Ficheros.Ejer04;

import java.io.*;

/*Combinación de archivos en uno solo: Escribir un programa en Java que permita
combinar varios archivos en uno solo. El programa debe tomar como entrada una lista de
archivos de origen y el nombre del archivo de destino. El programa debe leer cada archivo
de origen y escribir su contenido en el archivo de destino en el orden en que se
especificaron en la lista*/
public class Main {

    public static void main(String[] args) {

        File archivoDestino = new File("destino.txt");

        try {
            FileOutputStream salidaDestino = new FileOutputStream(archivoDestino);

            //recoremos la lista de archivos de origen
            for (String nomArchivo: args){
                System.out.println(nomArchivo);//no es necesario solo es para ver

                File archivoOrigen = new File(nomArchivo);
                FileInputStream entradaOrigen = new FileInputStream(archivoOrigen);

                //copiamos el contenido
                byte[] buffer = new byte[1024];
                int byteleidos;
                while ((byteleidos = entradaOrigen.read(buffer))!=-1){
                    salidaDestino.write(buffer, 0, byteleidos);
                }

                //cierro los recursos de lectura
                entradaOrigen.close();
            }
            //cierro recursos de escritura
            salidaDestino.close();
            System.out.println("Se han copiado");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
