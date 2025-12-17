package org.iesch.ad.Ev1_Ej3.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(nullable = false)
    private String nombre;

    @Basic
    @Column(unique = true,nullable = false)
    private String email;

    @Basic
    @Column(unique = true,nullable = false)
    private String telefono;


    @OneToMany(mappedBy = "cliente" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pedido> pedidos = new ArrayList<>();


}
