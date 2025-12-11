package org.iesch.ad.Ej2.servidor;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class PalabraProhibidaService {

    //Set para almacenar las palabras prohividas (busqueda 01), muy eficiente)
    private Set<String> palabrasProhibidas = new HashSet<>();
    //Nombre del archivo en la raiz
    private static final String ARCHIVO_PALABRAS = "palabrasProhibidas.txt";

    //Se ejecuta automaticamente al inicar la aplicacion
    //carga las palabras prohibidas una sola vez en memoria

    @PostConstruct
    public void cargarPalabrasProhibidas(){
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PALABRAS))){
            String linea;
            while ((linea = br.readLine())!= null){
                palabrasProhibidas.add(linea.trim().toLowerCase());
            }
            System.err.println("Palabras prohibidas cargadas: " + palabrasProhibidas.size());
        } catch (IOException e) {
            System.err.println("Error al cargar las palabras prohibidas: " + e.getMessage());
        }
    }

    //Metodo para verificar si un texto contiene alguna palabra prohibida
    //comparar paabra por palabra, ignorando mayusculas/minusculas
    public boolean contienePalabraProhibida(String texto){
        if (texto == null || texto.isEmpty()){
            return false;
        }
        String toLower = texto.toLowerCase();
        String[] palabras = toLower.split("\\s+");

        //verifico cada palabra
        for (String palabra : palabras){
            palabra = palabra.replaceAll("[^a-záéíóúñ]", "");

            //busco en el set operacion 0(1) muy rapida
            if (palabrasProhibidas.contains(palabra)){
                return true;
            }
        }
        return false;
    }
}
