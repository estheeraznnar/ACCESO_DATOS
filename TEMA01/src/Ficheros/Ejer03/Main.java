package Ficheros.Ejer03;

import java.io.*;

/*Cifrado y descifrado de archivos: Escribir un programa en Java que permita cifrar y
descifrar un archivo utilizando un algoritmo de cifrado. El programa debe tomar como
entrada el nombre del archivo de origen, el nombre del archivo de destino, y una clave de
cifrado. El cifrado debe ser reversible, es decir, el archivo cifrado debe poder ser
descifrado con la misma clave. Puedes usar el algoritmo de cifrado AES1*/
public class Main {

    public static void main(String[] args) {
        File archivoOrigien = new File("texto02.txt");
        FileInputStream entradaOrigen;

        try {
            //abrimos el archivo de lectura
            entradaOrigen = new FileInputStream(archivoOrigien);

            //creamos archivo para escritura
            File archivoDestino = new File("destinocifrado.txt");
            FileOutputStream salidaDestino = new FileOutputStream(archivoDestino);

            //Generamos una clave


        } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
        }

    }

}
