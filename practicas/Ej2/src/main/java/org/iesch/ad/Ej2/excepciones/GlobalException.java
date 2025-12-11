package org.iesch.ad.Ej2.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

// Manejador global de excepciones
@ControllerAdvice
public class GlobalException {

    //Maneja la excepcion personalizada
    @ExceptionHandler(MiExcepcion.class)
    public ResponseEntity<ErrorResponseDTO> handleMiExcepcion(MiExcepcion ex, WebRequest request){

        //Creo el DTO con la informacion del error
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );

        //Devuelvo la respuesta con codigo 404
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
