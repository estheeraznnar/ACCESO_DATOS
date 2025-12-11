package org.iesch.ad.Ej2.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Nombre del creador del post (obligatorio)
    @Column(nullable = false)
    String creador;
    @Column(nullable = false, columnDefinition = "TEXT") // Contenido completo del post (obligatorio, tipo TEXT en BD)
    String contenido;
    @Column(name = "ruta_imagen")
    String rutaImagen;
    @Column(nullable = false)
    LocalDateTime fecha;

    /**lista de comentarios asociados al post
     * mappedBy = "post" indica que la relacion se mapea por el atributo post en comentario
     * cascade=ALL al borrar un post se borran sus comentarios
     * OrphanRemoval = true: si se elimina un comentario de la lista, se borra en BD
     */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude //Evita un bucle infinito en el toString de (Post->Comentario->Post...)
    private List<Comentario> comentarios = new ArrayList<>();

    //Se ejecuta automaticamente andes de insertar el post en la bd
    //Asigna la fecha actual si no se ha puesto
    @PrePersist
    protected void onCreate(){
        this.fecha = LocalDateTime.now();
    }

    //Se ejecuta automaticamente antes de actualizar el post
    //Actualiza la fecha a ahora cuando se modifica el registro
    @PreUpdate
    protected void onUpdate(){
        this.fecha=LocalDateTime.now();
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
