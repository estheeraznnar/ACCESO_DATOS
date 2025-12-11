package org.iesch.ad.Ej2.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String creador;
    @Column(nullable = false, columnDefinition = "TEXT")
    String comentario;
    @Column(nullable = false)
    LocalDateTime fecha;

    //Muchos comentarios pertenecen a un solo post
    //post_id sera la columna fk en ka tabla comentrios
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @ToString.Exclude //Evita el bucle infinito del toString
    private Post post;

    //se ejecuta automaticamente antes de insertar el comentario en bd
    //asigna la fecha acutual
    @PrePersist
    protected void onCreate(){
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
