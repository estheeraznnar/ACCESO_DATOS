package org.iesch.ad.Ej2.control;

import org.iesch.ad.Ej2.excepciones.MiExcepcion;
import org.iesch.ad.Ej2.modelo.Comentario;
import org.iesch.ad.Ej2.modelo.Post;
import org.iesch.ad.Ej2.repositorio.ComentarioRepository;
import org.iesch.ad.Ej2.repositorio.PostRepository;
import org.iesch.ad.Ej2.servidor.PalabraProhibidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PalabraProhibidaService palabraProhibidaService;

    // 2.5 Obtener todos los posts
    // URL: GET /api/posts
    // Devuelve todos los posts con el contenido acortado a 60 caracteres
    @GetMapping("/posts")
    public ResponseEntity<List<Map<String, Object>>> obtenerTodosPosts() {
        List<Post> posts = postRepository.findAll();

        // Usamos Stream para transformar cada post
        List<Map<String, Object>> postsResumidos = posts.stream()
                .map(post -> {
                    Map<String, Object> postMap = new HashMap<>();
                    postMap.put("id", post.getId());
                    postMap.put("creador", post.getCreador());

                    // Acortamos el contenido a 60 caracteres
                    String contenido = post.getContenido();
                    if (contenido.length() > 60) {
                        contenido = contenido.substring(0, 60) + "...";
                    }
                    postMap.put("contenido", contenido);
                    postMap.put("rutaImagen", post.getRutaImagen());
                    postMap.put("fecha", post.getFecha());

                    return postMap;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(postsResumidos);
    }

    // 2.6 Obtener un post completo con sus comentarios
    // URL: GET /api/post/5
    // Devuelve el post completo (contenido sin acortar) y todos sus comentarios asociados
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> obtenerPost(@PathVariable Long id) throws MiExcepcion {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new MiExcepcion("No se encontró el post con id: " + id));

        return ResponseEntity.ok(post);
    }

    // 2.7 Crear un comentario en un post
    // URL: POST /api/post/5/comentario
    // Recibe JSON: {"creador": "nombre", "comentario": "texto del comentario"}
    // Verifica palabras prohibidas antes de guardar (case-insensitive)
    @PostMapping("/post/{id}/comentario")
    public ResponseEntity<Map<String, Object>> crearComentario(
            @PathVariable Long id,
            @RequestBody Map<String, String> datos) throws MiExcepcion {

        // Verificamos que el post exista
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new MiExcepcion("No se encontró el post con id: " + id));

        Map<String, Object> respuesta = new HashMap<>();
        String textoComentario = datos.get("comentario");

        // Verificamos si contiene palabras prohibidas (mayusculas o minusculas)
        if (palabraProhibidaService.contienePalabraProhibida(textoComentario)) {
            respuesta.put("comentario", "El comentario no se publicó por uso de lenguaje mal sonante");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }

        // Si no hay palabras prohibidas, guardamos el comentario
        Comentario comentario = new Comentario();
        comentario.setCreador(datos.get("creador"));
        comentario.setComentario(textoComentario);
        comentario.setPost(post);
        // La fecha se asigna automaticamente con @PrePersist

        Comentario comentarioGuardado = comentarioRepository.save(comentario);

        // Construimos la respuesta JSON
        respuesta.put("id", comentarioGuardado.getId());
        respuesta.put("creador", comentarioGuardado.getCreador());
        respuesta.put("comentario", comentarioGuardado.getComentario());
        respuesta.put("fecha", comentarioGuardado.getFecha());

        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

}
