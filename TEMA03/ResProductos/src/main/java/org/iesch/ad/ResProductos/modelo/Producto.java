package org.iesch.ad.ResProductos.modelo;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class Producto {
    long id;
    String nombre;
    double precio;
    String descripcion;
    String categoria;
    int stock;

    /* Tambien se puede hacer asi sin qponer el de arriba
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ptoducto ptoducto = (Ptoducto) o;
        return id == ptoducto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }*/
}
