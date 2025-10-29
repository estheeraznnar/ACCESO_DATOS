package org.iesch.ad.Excepciones.excepciones;

public class EstudianteNoEncontradoException extends RuntimeException {

    public EstudianteNoEncontradoException(Long id) {

        super("No se encontro al estudiante con ID: " + id);

    }

}
