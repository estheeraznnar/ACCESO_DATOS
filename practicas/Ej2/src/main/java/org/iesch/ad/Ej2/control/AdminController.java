package org.iesch.ad.Ej2.control;

import org.iesch.ad.Ej2.excepciones.MiExcepcion;
import org.iesch.ad.Ej2.modelo.Post;
import org.iesch.ad.Ej2.repositorio.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PostRepository postRepository;

    //Crear un nuevo post
    //Recibe el JSOn
    //La fecha se asigna automaticamente con @PrePersist
    @PostMapping("/crearPost")
    public ResponseEntity<Post> crearPost(@RequestBody Map<String, String> datos){
        Post post = new Post();
        post.setCreador(datos.get("creador"));
        post.setContenido(datos.get("contenido"));
        post.setRutaImagen(datos.get("rutaImagen"));

        Post postGuardado = postRepository.save(post);
        return new ResponseEntity<>(postGuardado, HttpStatus.CREATED);
    }

    // 2.3 Borrar un post por ID
    // URL: /admin/borrarPost/5
    // Borra el post y sus comentarios asociados (gracias a cascade)
    @DeleteMapping("/borrarPost/{id}")
    public ResponseEntity<Void> borrarPost(@PathVariable Long id) throws MiExcepcion{
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new MiExcepcion("No se encontró el post con id: " + id));
        postRepository.delete(post);
        return ResponseEntity.noContent().build();
    }

    // 2.4 Actualizar un post
    // URL: /admin/updatePost/5
    // Recibe JSON: {"creador": "nombre", "contenido": "nuevo texto", "rutaImagen": "url"}
    // La fecha se actualiza automaticamente con @PreUpdate
    @PutMapping("/updatePost/{id}")
    public ResponseEntity<Post> actualizarPost(@PathVariable Long id, @RequestBody Map<String, String> datos) throws MiExcepcion{
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new MiExcepcion("No se encontro el post con id: " + id));

        post.setCreador(datos.get("creador"));
        post.setContenido(datos.get("contenido"));
        post.setRutaImagen(datos.get("rutaImagen"));

        Post postActualizado = postRepository.save(post);
        return ResponseEntity.ok(postActualizado);
    }

}
