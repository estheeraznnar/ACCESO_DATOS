package org.iesch.ad.Excepciones.excepciones;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDuplicationException extends RuntimeException {

    public EmailDuplicationException(String email) {

        super("El email " + email + " ya esta registrado");

    }

}
