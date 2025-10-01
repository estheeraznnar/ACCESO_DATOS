package Ficheros.Ejer01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String filePath = "fichero01.txt";
        int linecount  =  countLines (filePath);
        System.out.println("numero de lineas: " + linecount);


    }

    private static int countLines(String filePath) {
        int lineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while (br.readLine() != null){
                lineas++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el fichero");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Problemas de entrada salida.");
            throw new RuntimeException(e);
        }
        return lineas;
    }
}
