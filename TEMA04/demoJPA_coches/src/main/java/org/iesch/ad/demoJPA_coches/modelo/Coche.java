package org.iesch.ad.demoJPA_coches.modelo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coche {

    //clase primaria en incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String matricula;
    private float cilindrada;
    private int potencia;
    private String color;

    @ManyToOne
    Persona persona;

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cilindrada=" + cilindrada +
                ", potencia=" + potencia +
                ", color='" + color + '\'' +
                ", persona ID=" + persona.getId() +
                ", persona Nombre=" + persona.getNombre() +
                '}';
    }
}
