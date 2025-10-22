package org.iesch.ad.Ejemplo_JSON.service;

import org.iesch.ad.Ejemplo_JSON.modelo.Persona;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

@Service
public class GuardarDatos {

    public String guarda(Persona persona){
        Path path = Paths.get("archivo.txt");

        try {
            Files.write(path, Arrays.asList(persona.toString()),
                    StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            return "Texto creado";
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Error al introducir texto en el fichero";
    }

}
