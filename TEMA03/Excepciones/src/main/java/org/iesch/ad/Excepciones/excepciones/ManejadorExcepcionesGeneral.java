package org.iesch.ad.Excepciones.excepciones;

import org.iesch.ad.Excepciones.modelo.dto.ErrorResponseDTO;
import org.iesch.ad.Excepciones.modelo.dto.EstudianteResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    /**
     *  Maneja la excepcion cuando hay un email duplicado
     *  Devuelve un 409 Conflict
     */
    @ExceptionHandler(EmailDuplicationException.class)
    public ResponseEntity<ErrorResponseDTO> manejarEmailDuplicado(
            EmailDuplicationException ex, WebRequest request
    ){
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Conflicr",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    /**
     * Maneja excepciones de datos invalidos
     * Devuelve 400 BadRequest
     */

    @ExceptionHandler(DatosInvalidosException.class)
    public ResponseEntity<ErrorResponseDTO> manejarDatosInvalidos(
        DatosInvalidosException ex, WebRequest request
    ){
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manejar las excepciones guardadas por @valid
     * usaremos la lista
     * Devuelve 400
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> validacion(
            MethodArgumentNotValidException ex, WebRequest request
    ){
        List<String> detalles = new ArrayList<>();

        //Extraer errores de validacion
        for (FieldError error: ex.getBindingResult().getFieldErrors()){
            detalles.add(error.getField() + ": " + error.getDefaultMessage());
        }
        ErrorResponseDTO error = new ErrorResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""),
                detalles
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
