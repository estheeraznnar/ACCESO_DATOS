package org.iesch.MongoDemo_Repository.modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//como es embebido no le hace falta ninguna etiqueta
public class Autor {
    private String nombre;
    private String nacionalidad;
}
