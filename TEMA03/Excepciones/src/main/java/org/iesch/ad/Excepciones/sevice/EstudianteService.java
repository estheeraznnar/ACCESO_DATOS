package org.iesch.ad.Excepciones.sevice;

import org.iesch.ad.Excepciones.excepciones.EstudianteNoEncontradoException;
import org.iesch.ad.Excepciones.modelo.Estudiante;
import org.iesch.ad.Excepciones.modelo.dto.EstudianteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EstudianteService {
    @Autowired
    Map<Long, Estudiante> estudiantes;

    public List<EstudianteResponseDTO> obtenerTodos() {

        List<Estudiante> listaEstudiante = new ArrayList<>(estudiantes.values());
        List<EstudianteResponseDTO> estudianteResponseDTOS =
                listaEstudiante.stream().map(EstudianteResponseDTO::new).toList();
        return estudianteResponseDTOS;
    }

    public EstudianteResponseDTO obtenerPorID(Long id) {
        Estudiante estudiante = estudiantes.get(id);
        if (estudiante != null){
            return new EstudianteResponseDTO(estudiante);
        }else {
            throw new EstudianteNoEncontradoException(id);
        }
    }
}
