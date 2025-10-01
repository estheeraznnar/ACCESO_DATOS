package Ficheros.Ejer02;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String sourceFile = "fichero01.txt";
        String destinationFile = "salida.txt";
        copyFile(sourceFile, destinationFile);


    }

    private static void copyFile(String sourceFile, String destinationFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter wr = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = br.readLine()) != null){
               wr.write(line);
               wr.newLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el fichero");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Problemas de entrada salida.");
            throw new RuntimeException(e);
        }

    }

}
