package org.iesch.DocumentosReferenciados.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "libros_ref")
public class BookRef {

    @Id
    private String id;

    private String titulo;
    private Integer anioPublicacion;
    private String isbn;
    private Double precio;
    private Integer numeroPaginas;
    private String editorial;

    //@DBRef
    @DocumentReference
    private List<AutoresRef> autores;
    private List<String> categorias;

    public BookRef(String titulo, Integer anioPublicacion, String isbn, Double precio, Integer numeroPaginas, String editorial, List<AutoresRef> autores, List<String> categorias) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.precio = precio;
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.autores = autores;
        this.categorias = categorias;
    }
}
