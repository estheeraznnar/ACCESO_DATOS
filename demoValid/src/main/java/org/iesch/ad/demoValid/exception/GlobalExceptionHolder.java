package org.iesch.ad.demoValid.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice //Para coger las excepciones
public class GlobalExceptionHolder {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> manejarDatosErroneos(MethodArgumentNotValidException ex){
        String mensaje = "Error de validacion: " + ex.getBindingResult().getFieldError().getDefaultMessage();
        //throw new MiExcepcion(mensaje);//coje mi excepcion cojiendo el mensaje //Manera rapida y facil de hacer pero cuenta menos
                                        //Es o esto o lo de abajo no las dos a la vez
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                mensaje);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);

    }

}
