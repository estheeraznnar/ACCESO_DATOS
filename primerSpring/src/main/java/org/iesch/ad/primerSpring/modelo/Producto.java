package org.iesch.ad.primerSpring.modelo;

import lombok.*;

//@Data  Esta sirve para poner to do de golpe
@Getter
@Setter
@ToString
/*@AllArgsConstructor
@NoArgsConstructor*/
//
@Builder
public class Producto {
    int id;
    String nombre;
    float precio;

}
