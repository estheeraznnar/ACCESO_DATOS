package org.iesch.ad.Ej2.excepciones;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ErrorResponseDTO {
    private LocalDateTime timestamp;  // Fecha y hora del error
    private int status;               // Código HTTP (404, 400, etc.)
    private String error;             // Tipo de error
    private String message;           // Mensaje descriptivo
    private String path;              // Ruta que generó el erro

    // Constructor manual (sin usar @AllArgsConstructor)
    public ErrorResponseDTO(LocalDateTime timestamp, int status, String error,
                            String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
