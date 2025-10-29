package org.iesch.ad.Excepciones.modelo.dto;

import lombok.*;
import org.iesch.ad.Excepciones.modelo.Estudiante;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteResponseDTO {
    private long id;
    private String nombre;
    private String apellidos;

    public EstudianteResponseDTO(Estudiante estudiante){
        this.id = estudiante.getId();
        this.nombre = estudiante.getNombre();
        this.apellidos = estudiante.getApellidos();
    }
}
