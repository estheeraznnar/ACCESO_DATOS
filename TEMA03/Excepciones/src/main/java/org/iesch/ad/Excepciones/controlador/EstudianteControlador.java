package org.iesch.ad.Excepciones.controlador;

import lombok.Getter;
import org.iesch.ad.Excepciones.modelo.Estudiante;
import org.iesch.ad.Excepciones.modelo.dto.EstudianteResponseDTO;
import org.iesch.ad.Excepciones.sevice.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteControlador {

    @Autowired
    EstudianteService estudiantesService;

    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>>  obtenerTodos(){
        List<EstudianteResponseDTO> estudianteList = estudiantesService.obtenerTodos();

        return  ResponseEntity.ok(estudianteList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> obtenerUno(@PathVariable Long id){
        EstudianteResponseDTO estudianteResponseDTO =estudiantesService.obtenerPorID(id);
        return ResponseEntity.ok(estudianteResponseDTO);
    }

    /*@PostMapping()
    public ResponseEntity<EstudianteResponseDTO> aña*/

}
