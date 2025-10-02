package Ejer02;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String archivoOriginal = "texto.txt";
        String archivonuevo = "archivoNuevo.txt";
        String textoBuscar = "Fiscalía";
        String cadenaRemplazo = "SACAR";

        buscarYreemplazar(archivoOriginal, archivonuevo, textoBuscar, cadenaRemplazo);
    }

    private static void buscarYreemplazar(String archivoOriginal, String archivonuevo, String textoBuscar, String cadenaRemplazo) {

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivonuevo))){

            String linea;
            while ((linea = br.readLine()) != null){
                String lineaModificada = linea.replace(textoBuscar, cadenaRemplazo);
                bw.write(lineaModificada);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
