package org.iesch.ad.Ev1_Ej3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(nullable = false)
    private String titulo;
    @Basic
    @Column(nullable = false)
    private Double precio;
    @Basic
    @Column(unique = true, nullable = false)
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "editorial_id")
    @JsonBackReference
    private Editorial editorial;

    @ManyToMany(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Pedido> pedidos = new ArrayList<>();


}
