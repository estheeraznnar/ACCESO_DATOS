package org.iesch.ad.Ej2.repositorio;

import org.iesch.ad.Ej2.modelo.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
