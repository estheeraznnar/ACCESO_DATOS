package org.iesch.ad.ResProductos.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Usuario {
    long id;
    String nombre;
    String apellido;
    String direccion;
    String passwd;
}
