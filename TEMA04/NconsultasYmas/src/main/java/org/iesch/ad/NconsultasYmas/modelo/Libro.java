package org.iesch.ad.NconsultasYmas.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "libros")

@Data //Hace referencia a Getter, Setter, Compare....
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String isbn;
    private Double precio;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    //por defecto es ansioso EAGER
    @ManyToOne(fetch = FetchType.LAZY)//Lo fuerzo a que sea LEAZY
    @JoinColumn(name = "autor_id", nullable = false)//lo uno por el id del autor y le obligo a que haya
    private Autor autor;

    public Libro(String titulo, String isbn, Double precio, Integer anioPublicacion, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.precio = precio;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }
}
