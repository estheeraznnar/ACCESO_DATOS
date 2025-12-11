package org.iesch.ad.Ejercicio01.modelo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Producto {
    long id;
    String nombre;
    double precio;
    String descripcion;
    String categoria;
    int stock;

}
