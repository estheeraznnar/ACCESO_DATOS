package org.iesch.ad.Excepciones.controlador;

import jakarta.validation.Valid;
import lombok.Getter;

import org.iesch.ad.Excepciones.modelo.dto.EstudianteRequestDTO;
import org.iesch.ad.Excepciones.modelo.dto.EstudianteResponseDTO;
import org.iesch.ad.Excepciones.sevice.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
    @CrossOrigin(origins =  "http://192.168.50.253")
    public ResponseEntity<List<EstudianteResponseDTO>>  obtenerTodos(){
        List<EstudianteResponseDTO> estudianteList = estudiantesService.obtenerTodos();

        return  ResponseEntity.ok(estudianteList);
    }

    /**
     * GET/api/estudiantes/{id}
     * obtener un estudiante por id
     * Puede lanzar excepciones: EstudianteNoEncontradoException
     */
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> obtenerUno(@PathVariable Long id){
        EstudianteResponseDTO estudianteResponseDTO =estudiantesService.obtenerPorID(id);
        return ResponseEntity.ok(estudianteResponseDTO);
    }

    /**
     * Post/api/estudiantes/
     * creo un estudiante nuevo
     * Puede lanzar excepciones: EmailDuplicationException
     */
    @PostMapping()
    public ResponseEntity<EstudianteResponseDTO> crearUser(@Valid @RequestBody EstudianteRequestDTO estudianteRequestDTO){

        EstudianteResponseDTO nuevoEstudiante = estudiantesService.crear(estudianteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

    /**
     *Put /api/estudiantes/id
     * Actualiza el estudiante
     */
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody EstudianteRequestDTO estudianteRequestDTO
    ){

        EstudianteResponseDTO estudianteActualizado = estudiantesService.actualizar(id, estudianteRequestDTO);
        return ResponseEntity.ok(estudianteActualizado);
    }

    /**
     * DLETE /api/estudiantes/id
     * Eliminar un estudiante
     * Puede lanzar excepciones EstudianteNoEncontradoException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        estudiantesService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * GET /api/estudiantes/ciclo/{ciclo}
     * Obtener estudiantes por ciclo formativo
     * puede lanzar excepciones: DatosInvalidosException o EstudianteNoEncontradoException
     */

    @GetMapping("/ciclo/{ciclo}")
    public  ResponseEntity<List<EstudianteResponseDTO>> obtenerPorCiclo(
        @PathVariable String ciclo
    ){
        List<EstudianteResponseDTO> list = estudiantesService.obtenerPorCiclo(ciclo);
        return ResponseEntity.ok(list);
    }

}
