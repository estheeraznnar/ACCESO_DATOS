package org.iesch.ad.Excepciones.config;



import org.iesch.ad.Excepciones.modelo.Estudiante;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Configuracion {

    @Bean
    public Map<Long, Estudiante> inicializa(){
        Map<Long, Estudiante> estudiantes = new HashMap<>();
        Estudiante estudiante1 = new Estudiante(1L, "Esther", "Aznar", "eaznard@iesch.org", 20, "DAM");
        Estudiante estudiante2 = new Estudiante(2L, "María", "Perez", "mperezsiesch.org", 19, "DWM");
        Estudiante estudiante3 = new Estudiante(3L, "Gema", "Sanchez", "gsanchezh@iesch.org", 22, "ASIR");

        estudiantes.put(estudiante1.getId(), estudiante1);
        estudiantes.put(estudiante2.getId(), estudiante2);
        estudiantes.put(estudiante3.getId(), estudiante3);
        return estudiantes;
    }

}
