package org.iesch.ad.demoJPA_coches.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String apellido;

    //clave ajena
//    @OneToOne
//    Coche coche;

    @OneToMany
    @JoinColumn(name = "persona_id")
    List<Coche> coches;
}
