package org.iesch.ad.Excepciones.excepciones;

import org.iesch.ad.Excepciones.modelo.dto.ErrorResponseDTO;
import org.iesch.ad.Excepciones.modelo.dto.EstudianteResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ManejadorExcepcionesGeneral {

    /**
     * Maneja la excepcion cuando no se encuentra el estudiante
     * Devuelve un 404 NotFound
     */
    @ExceptionHandler(EstudianteNoEncontradoException.class)
    public ResponseEntity<ErrorResponseDTO> manejarEstudianteNoEncontrado(
        EstudianteNoEncontradoException exception, WebRequest request
    ){
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                exception.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
